require 'elasticsearch'

# set up the client with the Compose connection strings
client = Elasticsearch::Client.new urls: 'https://username:password@portal113-2.latest-elasticsearch.compose-3.composedb.com:10113/, https://username:password@portal164-1.latest-elasticsearch.compose-3.composedb.com:10164/'

# print the cluster health
p client.cluster.health
