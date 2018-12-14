-- Drop table

-- DROP TABLE public.patients

CREATE TABLE public.patients (
	"name" varchar(150) NOT NULL,
	id_patient serial NOT NULL,
	document varchar(50) NOT NULL,
	bithdate date NOT NULL,
	status varchar(20) NOT NULL DEFAULT 'ACTIVE'::character varying,
	CONSTRAINT patients_document_key UNIQUE (document),
	CONSTRAINT patients_pkey PRIMARY KEY (id_patient)
)
WITH (
	OIDS=FALSE
) ;


-- Drop table

-- DROP TABLE public.vital_signs

CREATE TABLE public.vital_signs (
	id_vital_sign serial NOT NULL,
	description varchar(200) NOT NULL,
	high_level_description varchar(150) NOT NULL DEFAULT 'LOW'::character varying,
	low_level_description varchar(150) NULL,
	normal_level_description varchar(150) NOT NULL DEFAULT 'NORMAL'::character varying,
	status varchar(50) NOT NULL DEFAULT 'ACTIVE'::character varying,
	code varchar(50) NOT NULL,
	CONSTRAINT vital_sings_pkey PRIMARY KEY (id_vital_sign)
)
WITH (
	OIDS=FALSE
) ;


-- Drop table

-- DROP TABLE public.vital_signs_data

CREATE TABLE public.vital_signs_data (
	id_vital_sign_data serial NOT NULL,
	id_vital_sign int4 NOT NULL,
	min_age int4 NOT NULL,
	max_age int4 NOT NULL,
	max_healty_value int4 NOT NULL,
	min_healty_value int4 NOT NULL,
	CONSTRAINT vital_signs_data_pk PRIMARY KEY (id_vital_sign_data),
	CONSTRAINT vital_signs_data_vital_signs_fk FOREIGN KEY (id_vital_sign) REFERENCES vital_signs(id_vital_sign)
)
WITH (
	OIDS=FALSE
) ;

-- Drop table

-- DROP TABLE public.patien_vital_sign_history

CREATE TABLE public.patien_vital_sign_history (
	id_history serial NOT NULL,
	id_patient int4 NOT NULL,
	id_vital_sign int4 NOT NULL,
	value_vital_sign int4 NOT NULL,
	condition_description varchar(150) NULL,
	status varchar(50) NOT NULL DEFAULT 'ACTIVE'::character varying,
	register_date date NOT NULL DEFAULT now(),
	CONSTRAINT patient_vital_sign_pk PRIMARY KEY (id_history),
	CONSTRAINT patien_vital_sign_history_id_patient_fkey2 FOREIGN KEY (id_patient) REFERENCES patients(id_patient),
	CONSTRAINT patien_vital_sign_history_vital_signs_fk FOREIGN KEY (id_vital_sign) REFERENCES vital_signs(id_vital_sign)
)
WITH (
	OIDS=FALSE
) ;
