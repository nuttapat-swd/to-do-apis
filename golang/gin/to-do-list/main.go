package main

import (
	"github.com/gin-gonic/gin"
)

func main() {
	// Initialize Gin router
	r := gin.Default()

	// // Connect routes to controllers
	// routes.InitRoutes(r)

	// Run the server
	r.Run(":8080")
}
