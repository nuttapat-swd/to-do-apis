package controller

import (
	"net/http"

	"github.com/gin-gonic/gin"
	"github.com/nuttapat/gin-todo/models"
	"github.com/nuttapat/gin-todo/services/postgresql"
)

func CreateTag(ctx *gin.Context) {
	var newTag models.Tag
	db := postgresql.GetDB()

	if err := ctx.ShouldBindJSON(&newTag); err != nil {
		ctx.JSON(http.StatusBadRequest, gin.H{"error": err.Error()})
		return
	}

	db.Create(&newTag)

	ctx.JSON(http.StatusCreated, newTag)
}

func GetTags(ctx *gin.Context) {
	var tags []models.Tag
	db := postgresql.GetDB()

	db.Find(&tags)

	ctx.JSON(http.StatusOK, tags)
}

func GetTagByID(ctx *gin.Context) {
	var tag models.Tag
	db := postgresql.GetDB()

	id := ctx.Param("TagID")

	err := db.First(&tag, id).Error

	if err != nil {
		ctx.JSON(http.StatusNotFound, gin.H{"error": err.Error()})
		return
	}
	ctx.JSON(http.StatusOK, tag)
}

func UpdateTags(ctx *gin.Context) {
	var existingTag models.Tag
	db := postgresql.GetDB()

	tagID := ctx.Param("TagID")

	result := db.First(&existingTag, tagID).Error
	if result != nil {
		ctx.JSON(http.StatusNotFound, gin.H{"error": "Tag not found"})
		return
	}

	// Map JSON request body to a map
	var updates map[string]interface{}
	if err := ctx.ShouldBindJSON(&updates); err != nil {
		ctx.JSON(http.StatusBadRequest, gin.H{"error": err.Error()})
		return
	}
	// Update only the fields provided in the JSON request
	db.Model(&existingTag).Updates(updates)

	ctx.JSON(http.StatusOK, existingTag)

}

func DeleteTag(ctx *gin.Context) {
	var tag models.Tag
	db := postgresql.GetDB()

	id := ctx.Param("TagID")

	db.Delete(&tag, id)

	ctx.JSON(http.StatusNoContent, gin.H{})
}
