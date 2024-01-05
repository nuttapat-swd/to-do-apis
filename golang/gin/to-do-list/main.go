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

func main() {
	router := gin.New()

	db := postgresql.GetDB()
	db.AutoMigrate(&models.Tag{}, &models.Task{})

	router.Run(":8080")
}
