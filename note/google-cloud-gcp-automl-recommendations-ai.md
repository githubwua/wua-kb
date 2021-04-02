
Recommendations AI now uses the Retail API.

# BEFORE:

* Endpoint: https://recommendationengine.googleapis.com/
* Doc: 
  * Alpha: https://cloud.google.com/recommendations/alpha/docs/reference/rest
  * Beta: https://cloud.google.com/recommendations-ai/docs/reference/rest
* Discovery: https://recommendationengine.googleapis.com/$discovery/rest?version=v1alpha
* Versions: v1alpha, v1beta1

# AFTER: 
* Endpoint: https://retail.googleapis.com
* Doc: https://cloud.google.com/recommendations-ai/docs/apis?hl=en

# EXAMPLE:

v1beta1 Recommendations Engine API:
```
GET https://recommendationengine.googleapis.com/v1beta1/projects/PROJECT_NUMBER/locations/global/catalogs/default_catalog/operations/OPERATION_ID
```

v2 Retail API:
```
GET https://retail.googleapis.com/v2/PROJECT_NUMBER/locations/global/catalogs/default_catalog/operations/OPERATION_ID
```


# API Client Library

java: https://github.com/googleapis/java-recommendations-ai
