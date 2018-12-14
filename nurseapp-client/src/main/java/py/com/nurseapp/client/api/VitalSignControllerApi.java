/*
 * Nurse App api documentation
 * Nurse app api with all services provided.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: marcos.echague@gmail.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package py.com.nurseapp.client.api;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import py.com.nurseapp.client.model.ResponseVitalSignListDto;
import py.com.nurseapp.client.model.VitalSign;
import py.com.nursepp.client.ApiCallback;
import py.com.nursepp.client.ApiClient;
import py.com.nursepp.client.ApiException;
import py.com.nursepp.client.ApiResponse;
import py.com.nursepp.client.Configuration;
import py.com.nursepp.client.Pair;
import py.com.nursepp.client.ProgressRequestBody;
import py.com.nursepp.client.ProgressResponseBody;

public class VitalSignControllerApi {
    private ApiClient apiClient;

    public VitalSignControllerApi() {
        this(Configuration.getDefaultApiClient());
    }

    public VitalSignControllerApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for getVitalSignUsingGET
     * @param xNurseappApikey API KEY from the agent caller. (required)
     * @param id id (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getVitalSignUsingGETCall(String xNurseappApikey, Integer id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/vital-signs/{id}"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xNurseappApikey != null)
        localVarHeaderParams.put("x-nurseapp-apikey", apiClient.parameterToString(xNurseappApikey));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getVitalSignUsingGETValidateBeforeCall(String xNurseappApikey, Integer id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'xNurseappApikey' is set
        if (xNurseappApikey == null) {
            throw new ApiException("Missing the required parameter 'xNurseappApikey' when calling getVitalSignUsingGET(Async)");
        }
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling getVitalSignUsingGET(Async)");
        }
        

        com.squareup.okhttp.Call call = getVitalSignUsingGETCall(xNurseappApikey, id, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get vital sign
     * Get vital sign&#39;s data. given an cod of vital sign
     * @param xNurseappApikey API KEY from the agent caller. (required)
     * @param id id (required)
     * @return VitalSign
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public VitalSign getVitalSignUsingGET(String xNurseappApikey, Integer id) throws ApiException {
        ApiResponse<VitalSign> resp = getVitalSignUsingGETWithHttpInfo(xNurseappApikey, id);
        return resp.getData();
    }

    /**
     * Get vital sign
     * Get vital sign&#39;s data. given an cod of vital sign
     * @param xNurseappApikey API KEY from the agent caller. (required)
     * @param id id (required)
     * @return ApiResponse&lt;VitalSign&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<VitalSign> getVitalSignUsingGETWithHttpInfo(String xNurseappApikey, Integer id) throws ApiException {
        com.squareup.okhttp.Call call = getVitalSignUsingGETValidateBeforeCall(xNurseappApikey, id, null, null);
        Type localVarReturnType = new TypeToken<VitalSign>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get vital sign (asynchronously)
     * Get vital sign&#39;s data. given an cod of vital sign
     * @param xNurseappApikey API KEY from the agent caller. (required)
     * @param id id (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getVitalSignUsingGETAsync(String xNurseappApikey, Integer id, final ApiCallback<VitalSign> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getVitalSignUsingGETValidateBeforeCall(xNurseappApikey, id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<VitalSign>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getVitalSignsUsingGET
     * @param xNurseappApikey API KEY from the agent caller. (required)
     * @param code code (optional)
     * @param maxAge max-age (optional)
     * @param minAge min-age (optional)
     * @param maxValue max-value (optional)
     * @param minValue min-value (optional)
     * @param description description (optional)
     * @param status status (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getVitalSignsUsingGETCall(String xNurseappApikey, String code, Integer maxAge, Integer minAge, Integer maxValue, Integer minValue, String description, String status, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/vital-signs";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (code != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("code", code));
        if (maxAge != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("max-age", maxAge));
        if (minAge != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("min-age", minAge));
        if (maxValue != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("max-value", maxValue));
        if (minValue != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("min-value", minValue));
        if (description != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("description", description));
        if (status != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("status", status));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xNurseappApikey != null)
        localVarHeaderParams.put("x-nurseapp-apikey", apiClient.parameterToString(xNurseappApikey));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getVitalSignsUsingGETValidateBeforeCall(String xNurseappApikey, String code, Integer maxAge, Integer minAge, Integer maxValue, Integer minValue, String description, String status, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'xNurseappApikey' is set
        if (xNurseappApikey == null) {
            throw new ApiException("Missing the required parameter 'xNurseappApikey' when calling getVitalSignsUsingGET(Async)");
        }
        

        com.squareup.okhttp.Call call = getVitalSignsUsingGETCall(xNurseappApikey, code, maxAge, minAge, maxValue, minValue, description, status, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get vital signs
     * Get list of vital signs
     * @param xNurseappApikey API KEY from the agent caller. (required)
     * @param code code (optional)
     * @param maxAge max-age (optional)
     * @param minAge min-age (optional)
     * @param maxValue max-value (optional)
     * @param minValue min-value (optional)
     * @param description description (optional)
     * @param status status (optional)
     * @return ResponseVitalSignListDto
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ResponseVitalSignListDto getVitalSignsUsingGET(String xNurseappApikey, String code, Integer maxAge, Integer minAge, Integer maxValue, Integer minValue, String description, String status) throws ApiException {
        ApiResponse<ResponseVitalSignListDto> resp = getVitalSignsUsingGETWithHttpInfo(xNurseappApikey, code, maxAge, minAge, maxValue, minValue, description, status);
        return resp.getData();
    }

    /**
     * Get vital signs
     * Get list of vital signs
     * @param xNurseappApikey API KEY from the agent caller. (required)
     * @param code code (optional)
     * @param maxAge max-age (optional)
     * @param minAge min-age (optional)
     * @param maxValue max-value (optional)
     * @param minValue min-value (optional)
     * @param description description (optional)
     * @param status status (optional)
     * @return ApiResponse&lt;ResponseVitalSignListDto&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ResponseVitalSignListDto> getVitalSignsUsingGETWithHttpInfo(String xNurseappApikey, String code, Integer maxAge, Integer minAge, Integer maxValue, Integer minValue, String description, String status) throws ApiException {
        com.squareup.okhttp.Call call = getVitalSignsUsingGETValidateBeforeCall(xNurseappApikey, code, maxAge, minAge, maxValue, minValue, description, status, null, null);
        Type localVarReturnType = new TypeToken<ResponseVitalSignListDto>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get vital signs (asynchronously)
     * Get list of vital signs
     * @param xNurseappApikey API KEY from the agent caller. (required)
     * @param code code (optional)
     * @param maxAge max-age (optional)
     * @param minAge min-age (optional)
     * @param maxValue max-value (optional)
     * @param minValue min-value (optional)
     * @param description description (optional)
     * @param status status (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getVitalSignsUsingGETAsync(String xNurseappApikey, String code, Integer maxAge, Integer minAge, Integer maxValue, Integer minValue, String description, String status, final ApiCallback<ResponseVitalSignListDto> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getVitalSignsUsingGETValidateBeforeCall(xNurseappApikey, code, maxAge, minAge, maxValue, minValue, description, status, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ResponseVitalSignListDto>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}