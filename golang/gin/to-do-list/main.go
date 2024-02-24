package main

import (
	"net/http"

	"github.com/gin-gonic/gin"
	"github.com/nuttapat/gin-todo/models"
	"github.com/nuttapat/gin-todo/routes"
	"github.com/nuttapat/gin-todo/services/postgresql"
)

func hello(ctx *gin.Context) {
	ctx.JSON(http.StatusOK, gin.H{"message": "world"})
}

func test(ctx *gin.Context) {
	ctx.String(200, "test")
}

func main() {
	app_router := gin.New()
	app_router.ForwardedByClientIP = true
	app_router.SetTrustedProxies([]string{"127.0.0.1"})
	db := postgresql.GetDB()
	db.AutoMigrate(&models.Tag{}, &models.Task{})

	app_router.GET("/", func(ctx *gin.Context) {
		ctx.String(200, "test")
	})
	// Initialize routes
	routes.InitRoutes(app_router)

	app_router.Run(":8080")
}
