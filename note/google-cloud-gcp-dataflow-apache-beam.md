# Pipeline Options

https://beam.apache.org/releases/javadoc/2.27.0/index.html?org/apache/beam/sdk/options/PipelineOptions.html
https://github.com/apache/beam/blob/master/runners/google-cloud-dataflow-java/src/main/java/org/apache/beam/runners/dataflow/options/DataflowPipelineOptions.java#L143

TODO: add sample code snippets

# Google I/O Connectors

- Java: [org.apache.beam.sdk.io.gcp.bigquery.*](https://github.com/apache/beam/tree/master/sdks/java/io/google-cloud-platform/src/main/java/org/apache/beam/sdk/io/gcp/)
- Python: [apache_beam.io.gcp.*](https://github.com/apache/beam/tree/master/sdks/python/apache_beam/io/gcp)


- [BigQueryIO](https://beam.apache.org/documentation/io/built-in/google-bigquery/)

# Template

## How to start/launch/execute a Dataflow template deployed on Google Cloud Storage (GCS)

Templates are staged on [Google Cloud Storage](#google-dataflow-template-repository-on-gcs).  Staged templates can be executed using the gcloud CLI tool.
The runtime parameters required by the template can be passed in the parameters field via comma-separated list of paramName=Value.

e.g.

```
export JOB=my-export-job  # A name for the job. Not unique.  A unique job ID will be generated for each launch.
export TEMPLATE='gs://dataflow-templates/latest/Cloud_Spanner_to_GCS_Avro'
export REGION=asia-northeast1
export GCS_BUCKET=xxxxxxx

gcloud dataflow jobs run $JOB \
  --gcs-location=$TEMPLATE \
  --region=$REGION \
  --max-workers=10 \
  --parameters="instanceId=test-instance,databaseId=example-db,outputDir=gs://$GCS_BUCKET/output/,shouldExportTimestampAsLogicalType=true"
```

## How to build/deploy/stage/upload a template to Google Cloud Storage

Use Maven to build and stage the template file on Google Cloud Storage.
Note: Any parameters passed at template build time will not be able to be overwritten at execution time.

e.g.

```
mvn compile exec:java \
-Dexec.mainClass=com.google.cloud.teleport.templates.<template-class> \
-Dexec.cleanupDaemonThreads=false \
-Dexec.args=" \
--project=<project-id> \                                   # When launching this template after it is deployed, project on which to run the template job
--stagingLocation=gs://<bucket-name>/staging \             # When launching this template after it is deployed, location for binary staging files for the job.                 
--tempLocation=gs://<bucket-name>/temp \                   # When launching this template after it is deployed, location for the job to store temporary files 
--templateLocation=gs://gcs-path-to/template-name.json \   # This is a definition file for the template.
--runner=DataflowRunner"                                   # When launching this template after it is deployed, runner on which to run the template job
```

Ref: 
- [Source Code](https://github.com/GoogleCloudPlatform/DataflowTemplates/)
- [Get started with Google-provided templates  |  Cloud Dataflow](https://cloud.google.com/dataflow/docs/guides/templates/provided-templates)

## Google Dataflow Template Repository on GCS

Available templates as of 2021-04-12

```
$ gsutil ls -l gs://dataflow-templates/latest/
    153695  2021-04-07T23:37:37Z  gs://dataflow-templates/latest/Bulk_Compress_GCS_Files
      1324  2021-04-07T23:37:37Z  gs://dataflow-templates/latest/Bulk_Compress_GCS_Files_metadata
    153560  2021-04-07T23:37:38Z  gs://dataflow-templates/latest/Bulk_Decompress_GCS_Files
      1309  2021-04-07T23:37:38Z  gs://dataflow-templates/latest/Bulk_Decompress_GCS_Files_metadata
     31211  2021-04-07T23:37:38Z  gs://dataflow-templates/latest/Cassandra_To_Cloud_Bigtable
      3210  2021-04-07T23:37:39Z  gs://dataflow-templates/latest/Cassandra_To_Cloud_Bigtable_metadata
    718911  2021-04-07T23:37:39Z  gs://dataflow-templates/latest/Cloud_BigQuery_to_GCS_TensorFlow_Records
      1962  2021-04-07T23:37:39Z  gs://dataflow-templates/latest/Cloud_BigQuery_to_GCS_TensorFlow_Records_metadata
    128524  2021-04-07T23:37:40Z  gs://dataflow-templates/latest/Cloud_Bigtable_to_GCS_Avro
      1429  2021-04-07T23:37:40Z  gs://dataflow-templates/latest/Cloud_Bigtable_to_GCS_Avro_metadata
    159609  2021-04-07T23:37:40Z  gs://dataflow-templates/latest/Cloud_Bigtable_to_GCS_Parquet
      1625  2021-04-07T23:37:41Z  gs://dataflow-templates/latest/Cloud_Bigtable_to_GCS_Parquet_metadata
    131657  2021-04-07T23:37:41Z  gs://dataflow-templates/latest/Cloud_Bigtable_to_GCS_SequenceFile
      1758  2021-04-07T23:37:41Z  gs://dataflow-templates/latest/Cloud_Bigtable_to_GCS_SequenceFile_metadata
    163177  2021-04-07T23:37:42Z  gs://dataflow-templates/latest/Cloud_PubSub_to_Avro
      2995  2021-04-07T23:37:42Z  gs://dataflow-templates/latest/Cloud_PubSub_to_Avro_metadata
     32324  2021-04-07T23:37:42Z  gs://dataflow-templates/latest/Cloud_PubSub_to_Cloud_PubSub
      1601  2021-04-07T23:37:43Z  gs://dataflow-templates/latest/Cloud_PubSub_to_Cloud_PubSub_metadata
    147243  2021-04-07T23:37:43Z  gs://dataflow-templates/latest/Cloud_PubSub_to_GCS_Text
      2396  2021-04-07T23:37:44Z  gs://dataflow-templates/latest/Cloud_PubSub_to_GCS_Text_metadata
     88118  2021-04-07T23:37:44Z  gs://dataflow-templates/latest/Cloud_PubSub_to_Splunk
      3916  2021-04-07T23:37:45Z  gs://dataflow-templates/latest/Cloud_PubSub_to_Splunk_metadata
    862129  2021-04-07T23:37:45Z  gs://dataflow-templates/latest/Cloud_Spanner_to_GCS_Avro
      2185  2021-04-07T23:37:45Z  gs://dataflow-templates/latest/Cloud_Spanner_to_GCS_Avro_metadata
    108549  2021-04-07T23:37:46Z  gs://dataflow-templates/latest/Datastore_to_Datastore_Delete
      2502  2021-04-07T23:37:46Z  gs://dataflow-templates/latest/Datastore_to_Datastore_Delete_metadata
    191025  2021-04-07T23:37:47Z  gs://dataflow-templates/latest/Datastore_to_GCS_Text
      2029  2021-04-07T23:37:47Z  gs://dataflow-templates/latest/Datastore_to_GCS_Text_metadata
     32232  2021-04-07T23:37:47Z  gs://dataflow-templates/latest/GCS_Avro_to_Cloud_Bigtable
      1709  2021-04-07T23:37:48Z  gs://dataflow-templates/latest/GCS_Avro_to_Cloud_Bigtable_metadata
   3522905  2021-04-07T23:37:48Z  gs://dataflow-templates/latest/GCS_Avro_to_Cloud_Spanner
      1522  2021-04-07T23:37:48Z  gs://dataflow-templates/latest/GCS_Avro_to_Cloud_Spanner_metadata
     83797  2021-04-07T23:37:49Z  gs://dataflow-templates/latest/GCS_Parquet_to_Cloud_Bigtable
      1692  2021-04-07T23:37:49Z  gs://dataflow-templates/latest/GCS_Parquet_to_Cloud_Bigtable_metadata
     30006  2021-04-07T23:37:49Z  gs://dataflow-templates/latest/GCS_SequenceFile_to_Cloud_Bigtable
      1566  2021-04-07T23:37:50Z  gs://dataflow-templates/latest/GCS_SequenceFile_to_Cloud_Bigtable_metadata
    345530  2021-04-07T23:37:50Z  gs://dataflow-templates/latest/GCS_Text_to_BigQuery
      2177  2021-04-07T23:37:50Z  gs://dataflow-templates/latest/GCS_Text_to_BigQuery_metadata
     18402  2021-04-07T23:37:50Z  gs://dataflow-templates/latest/GCS_Text_to_Cloud_PubSub
       816  2021-04-07T23:37:51Z  gs://dataflow-templates/latest/GCS_Text_to_Cloud_PubSub_metadata
   3056606  2021-04-07T23:37:51Z  gs://dataflow-templates/latest/GCS_Text_to_Cloud_Spanner
      3408  2021-04-07T23:37:52Z  gs://dataflow-templates/latest/GCS_Text_to_Cloud_Spanner_metadata
    151660  2021-04-07T23:37:52Z  gs://dataflow-templates/latest/GCS_Text_to_Datastore
      1723  2021-04-07T23:37:52Z  gs://dataflow-templates/latest/GCS_Text_to_Datastore_metadata
    382973  2021-04-07T23:37:53Z  gs://dataflow-templates/latest/Jdbc_to_BigQuery
      4334  2021-04-07T23:37:53Z  gs://dataflow-templates/latest/Jdbc_to_BigQuery_metadata
    234156  2021-04-07T23:37:53Z  gs://dataflow-templates/latest/PubSub_Subscription_to_BigQuery
      2342  2021-04-07T23:37:54Z  gs://dataflow-templates/latest/PubSub_Subscription_to_BigQuery_metadata
    234044  2021-04-07T23:37:54Z  gs://dataflow-templates/latest/PubSub_to_BigQuery
      2326  2021-04-07T23:37:54Z  gs://dataflow-templates/latest/PubSub_to_BigQuery_metadata
    252849  2021-04-07T23:37:55Z  gs://dataflow-templates/latest/Spanner_to_GCS_Text
      2297  2021-04-07T23:37:55Z  gs://dataflow-templates/latest/Spanner_to_GCS_Text_metadata
    338483  2021-04-07T23:37:55Z  gs://dataflow-templates/latest/Stream_DLP_GCS_Text_to_BigQuery
      2756  2021-04-07T23:37:56Z  gs://dataflow-templates/latest/Stream_DLP_GCS_Text_to_BigQuery_metadata
    341458  2021-04-07T23:37:56Z  gs://dataflow-templates/latest/Stream_GCS_Text_to_BigQuery
      2940  2021-04-07T23:37:56Z  gs://dataflow-templates/latest/Stream_GCS_Text_to_BigQuery_metadata
    195550  2021-04-07T23:37:57Z  gs://dataflow-templates/latest/Stream_GCS_Text_to_Cloud_PubSub
       849  2021-04-07T23:37:57Z  gs://dataflow-templates/latest/Stream_GCS_Text_to_Cloud_PubSub_metadata
    141514  2021-04-07T23:37:58Z  gs://dataflow-templates/latest/Word_Count
       899  2021-04-07T23:37:58Z  gs://dataflow-templates/latest/Word_Count_metadata
                                 gs://dataflow-templates/latest/flex/
                                 gs://dataflow-templates/latest/ui_metadata/
TOTAL: 60 objects, 12495494 bytes (11.92 MiB)
```

Sample Template Content:
https://storage.googleapis.com/dataflow-templates/latest/GCS_Avro_to_Cloud_Bigtable

# #deadletterqueue split tee

- [Guide to common Cloud Dataflow use-case patterns, Part 1 | Google Cloud Blog]

# #troubleshooting

#oom #memory
https://cloud.google.com/community/tutorials/dataflow-debug-oom-conditions

# #monitoring

https://cloud.google.com/dataflow/docs/guides/using-cloud-monitoring#receive_worker_vm_metrics_from_the_agent

# #reference

- [Tips and tricks to get your Cloud Dataflow pipelines into production | Google Cloud Blog](https://cloud.google.com/blog/products/data-analytics/tips-and-tricks-to-get-your-cloud-dataflow-pipelines-into-production)
- [How are Java exceptions handled in Cloud Dataflow?](https://cloud.google.com/dataflow/docs/resources/faq#how-are-java-exceptions-handled-in-cloud-dataflow)
- [Guide to common Cloud Dataflow use-case patterns, Part 1 | Google Cloud Blog]:
https://cloud.google.com/blog/products/data-analytics/guide-to-common-cloud-dataflow-use-case-patterns-part-1

