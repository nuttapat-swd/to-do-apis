package routes

import (
	"github.com/gin-gonic/gin"
)

func InitRoutes(router *gin.Engine) {

	v1 := router.Group("/api/v1")

	// Initialize tag routes separately
	InitTagRoutes(v1)
}
