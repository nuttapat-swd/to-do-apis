package main

import (
	"net/http"

	"github.com/gin-gonic/gin"
	"github.com/nuttapat/gin-todo/models"
	"github.com/nuttapat/gin-todo/services/postgresql"
)

func hello(ctx *gin.Context) {
	ctx.JSON(http.StatusOK, gin.H{"message": "world"})
}

func test(ctx *gin.Context) {
	ctx.String(200, "test")
}

func main() {
	router := gin.New()
	router.ForwardedByClientIP = true
	router.SetTrustedProxies([]string{"127.0.0.1"})
	db := postgresql.GetDB()
	db.AutoMigrate(&models.Tag{}, &models.Task{})

	router.GET("/test", test)

	router.Run(":8080")
}
