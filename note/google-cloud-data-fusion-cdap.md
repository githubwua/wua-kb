
# #rest #api

First thing first, set up these commonly used config parameters as necessary.

```
export PROJECT=PROJECT_ID
export LOCATION=REGION
export DATA_FUSION_API_NAME=datafusion.googleapis.com
export API_VERSION=v1beta1

export HTTP_METHOD=POST  # GET, POST, PUT, DELETE

# for payload, either use a payload file, or define it on the fly
#export PAYLOAD='{"description": "Private CDF instance created through REST.", "type": "ENTERPRISE", "privateInstance": true, "networkConfig": {"network": "projects/shared_vpc_host_project_id/global/networks/network", "ipAllocation": "ip_range"}}'
#export PAYLOAD='@/path/to/payload.json'
```

## Basic syntax:

```
curl \
  -H "Authorization: Bearer $(gcloud auth print-access-token)" \
  -H "Content-Type: application/json" \
  -X $HTTP_METHOD \
  -d $PAYLOAD \
  https://$DATA_FUSION_API_NAME/$API_VERSION/projects/$PROJECT/locations/$LOCATION/instances?instanceId=instance_id \
```

## Curl Examples:

```
# Create a private instance in a shared VPC network
curl -H "Authorization: Bearer $(gcloud auth print-access-token)" -H "Content-Type: application/json" https://$DATA_FUSION_API_NAME/v1beta1/projects/$PROJECT/locations/$LOCATION/instances?instanceId=instance_id -X POST -d '{"description": "Private CDF instance created through REST.", "type": "ENTERPRISE", "privateInstance": true, "networkConfig": {"network": "projects/shared_vpc_host_project_id/global/networks/network", "ipAllocation": "ip_range"}}'

```
# #plugin

Source Code: https://github.com/data-integrations/google-cloud

# #faq

## How do we set up a private IP network?

See: https://cloud.google.com/data-fusion/docs/how-to/create-private-ip?hl=en#create_a_private_instance_in_a_shared_network


