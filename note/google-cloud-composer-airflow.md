
# #config

Airflow config file path: /home/airflow/gcs/airflow.cfg

> NOTE: Do not modify the config file directly.  Use Config Override to modify

Config Override:
- GUI: Cloud Console > Composer > Instance > AIRFLOW CONFIGURATION OVERRIDES
- CLI: See #cmd

Example:
https://github.com/githubwua/wua-kb/blob/9114f4f287266542723428eac5db4f2f62189f16/config/composer-airflow.cfg

Doc:
https://github.com/apache/airflow/blob/master/airflow/config_templates/default_airflow.cfg


# #webserver

[Airflow webserverのUIには2種類のUIが存在する](https://ohbarye.hatenablog.jp/entry/2020/10/18/why-airflow-have-two-web-ui)

As of version 1.10.0, we can use a new UI called RBAC.  By default, Composer uses the legacy UI.  To enable RBAC, do this:

# #cmd

See: https://raw.githubusercontent.com/githubwua/wua-kb/main/cmd/gcloud-composer

