from elasticsearch import Elasticsearch

es = Elasticsearch(
    # Compose connection strings
    [
        'https://username:password@portal113-2.latest-elasticsearch.compose-3.composedb.com:10113/', 'https://username:password@portal164-1.latest-elasticsearch.compose-3.composedb.com:10164/'
    ]
)
# print the cluster health 
print(es.cluster.health())
