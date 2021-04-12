

# Template

## How to start/launch/execute a Dataflow template deployed on Google Cloud Storage (GCS)

Templates are staged on Google Cloud Storage.  Staged templates can be executed using the gcloud CLI tool.
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



# #deadletterqueue split tee

- [Guide to common Cloud Dataflow use-case patterns, Part 1 | Google Cloud Blog]


# #reference

- [Tips and tricks to get your Cloud Dataflow pipelines into production | Google Cloud Blog](https://cloud.google.com/blog/products/data-analytics/tips-and-tricks-to-get-your-cloud-dataflow-pipelines-into-production)
- [How are Java exceptions handled in Cloud Dataflow?](https://cloud.google.com/dataflow/docs/resources/faq#how-are-java-exceptions-handled-in-cloud-dataflow)
- [Guide to common Cloud Dataflow use-case patterns, Part 1 | Google Cloud Blog]:
https://cloud.google.com/blog/products/data-analytics/guide-to-common-cloud-dataflow-use-case-patterns-part-1

