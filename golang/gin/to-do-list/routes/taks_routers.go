package routes

import (
	"github.com/gin-gonic/gin"
	"github.com/nuttapat/gin-todo/controllers"
)

func InitTaskRouters(defaultRount *gin.RouterGroup) {
	taskGroup := defaultRount.Group("/tasks")
	{
		taskGroup.POST("/", controllers.CreateTask)
	}
}
