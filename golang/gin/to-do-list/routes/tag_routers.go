package routes

import (
	"net/http"

	"github.com/gin-gonic/gin"
	"github.com/nuttapat/gin-todo/controllers"
)

func InitTagRoutes(defaultRount *gin.RouterGroup) {
	tagGroup := defaultRount.Group("/tags")
	{
		tagGroup.GET("/test", func(c *gin.Context) {
			c.JSON(http.StatusOK, gin.H{"message": "world"})
		})
		tagGroup.POST("/", controllers.CreateTag)
		tagGroup.GET("/", controllers.GetTags)
		tagGroup.GET("/:TagID", controllers.GetTagByID)
		tagGroup.PATCH("/:TagID", controllers.UpdateTags)
		tagGroup.DELETE("/:TagID", controllers.DeleteTag)

	}
}
