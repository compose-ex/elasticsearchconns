const elasticsearch = require('elasticsearch');

const client = new elasticsearch.Client({
// Compose connection strings
  hosts: [
    "https://username:password@portal113-2.latest-elasticsearch.compose-3.composedb.com:10113/", "https://username:password@portal164-1.latest-elasticsearch.compose-3.composedb.com:10164/"]
});

// view the health of a cluster
client.cluster.health((err, res) => {
  if (err) throw err;
  console.log(res);
  client.close();
  process.exit(0);
});
