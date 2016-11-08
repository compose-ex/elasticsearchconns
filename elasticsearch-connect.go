package elasticsearchConnect

import (
	"fmt"
	"log"

	"gopkg.in/olivere/elastic.v3"
)

func main() {
	client, err := elastic.NewClient(
		// Compose connection strings
		elastic.SetURL("https://username:password@portal113-2.latest-elasticsearch.compose-3.composedb.com:10113/", "https://username:password@portal164-1.latest-elasticsearch.compose-3.composedb.com:10164/"),
		elastic.SetSniff(false),
	)
	if err != nil {
		log.Fatal(err)
	}

	// build the cluster health call
	health, err := client.ClusterHealth().Do()
	if err != nil {
		log.Fatal(err)
	}
	fmt.Printf("<------ Cluster Health ------>\n%+v\n", health)
}
