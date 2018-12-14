package py.com.nurseapp.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.classmate.TypeResolver;
import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import py.com.nurseapp.constants.NurseAppConstans;
import py.com.nurseapp.exception.ErrorResponse;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@PropertySource("classpath:swagger.properties")
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Autowired
	private TypeResolver typeResolver;

//	@Autowired 
//	private ServletContext servletContext;
//	
	@Value("${contact.name}")
	private String contactName;
	@Value("${contact.url}")
	private String contactUrl;
	@Value("${contact.email}")
	private String contactEmail;
	@Value("${title}")
	private String title;
	@Value("${description}")
	private String description;

	@Value("${springfox.documentation.swagger.v2.path}")
	private String path;

	@Value("${version}")
	private String version;

	@Bean
	public Docket apiAllVersions() {
		// new ModelRef(type)
		List<ResponseMessage> errors = getErrorMessages();

		Docket docket = new Docket(DocumentationType.SWAGGER_2)
//				.pathProvider(new RelativePathProvider(servletContext) {
//					@Override
//					public String getApplicationBasePath() {
//						return "/v"+version+"/api-docs";
//					}
//				})
				.select().apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
				.paths(PathSelectors.any()).build().globalOperationParameters(getGlobalOperationParameters())
				.produces(Sets.newHashSet("application/json", "application/xml")).useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, errors).globalResponseMessage(RequestMethod.POST, errors)
				.globalResponseMessage(RequestMethod.PUT, errors).globalResponseMessage(RequestMethod.DELETE, errors)
				.additionalModels(typeResolver.resolve(ErrorResponse.class)).apiInfo(apiInfo());

		return docket;
	}

	private List<Parameter> getGlobalOperationParameters() {
		return Lists.newArrayList(new ParameterBuilder().name(NurseAppConstans.HEADER_API_KEY)
				.description("API KEY from the agent caller.").modelRef(new ModelRef("string")).parameterType("header")
				.required(true).build());
	}

	private List<ResponseMessage> getErrorMessages() {
		List<ResponseMessage> errors = new ArrayList<ResponseMessage>();
		errors.add(new ResponseMessageBuilder().code(HttpStatus.BAD_REQUEST.value()).message("Invalid Request")
				.responseModel(new ModelRef("ErrorResponse")).build());
		errors.add(new ResponseMessageBuilder().code(HttpStatus.UNAUTHORIZED.value()).message("Security exception")
				.responseModel(new ModelRef("ErrorResonse")).build());
		errors.add(new ResponseMessageBuilder().code(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.message("Unexpected exception").responseModel(new ModelRef("ErrorResponse")).build());
		return errors;
	}

	private ApiInfo apiInfo() {

		ApiInfo apiInfo = new ApiInfoBuilder().contact(new Contact(contactName, contactUrl, contactEmail)).title(title)
				.description(description).version(version).build();
		return apiInfo;
	}

}
