package routes

import (
	"net/http"

	"github.com/gin-gonic/gin"
	controller "github.com/nuttapat/gin-todo/controllers/tag"
)

func InitTagRoutes(defaultRount *gin.RouterGroup) {
	tagGroup := defaultRount.Group("/tags")
	{
		tagGroup.GET("/test", func(c *gin.Context) {
			c.JSON(http.StatusOK, gin.H{"message": "world"})
		})
		tagGroup.POST("/", controller.CreateTag)
		tagGroup.GET("/", controller.GetTags)
		tagGroup.GET("/:TagID", controller.GetTagByID)
		tagGroup.PATCH("/:TagID", controller.UpdateTags)
		tagGroup.DELETE("/:TagID", controller.DeleteTag)

	}
}
