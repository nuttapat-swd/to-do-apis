package controllers

import (
	"fmt"
	"net/http"

	"github.com/gin-gonic/gin"
	"github.com/nuttapat/gin-todo/models"
	"github.com/nuttapat/gin-todo/services/postgresql"
)

func CreateTask(ctx *gin.Context) {
	var newTask map[string]interface{}
	db := postgresql.GetDB()

	if err := ctx.ShouldBindJSON(&newTask); err != nil {
		ctx.JSON(http.StatusBadRequest, gin.H{"error": err.Error()})
		return
	}
	tagIdsInput, exists := newTask["tagList"]
	if exists {
		tagsIds := make([]int, len(tagIdsInput.([]interface{})))
		for i, v := range tagIdsInput.([]interface{}) {
			if intValue, ok := v.(float64); ok {
				tagsIds[i] = int(intValue)
			} else {
				fmt.Printf("Element at index %d is not an integer\n", v)
			}
		}
		tags, _ := models.GetTagByIDs(tagsIds)
		newTask["TagList"] = tags
	}

	var task models.Task

	if err := db.Model(&task).Create(newTask).Error; err != nil {
		ctx.JSON(http.StatusInternalServerError, gin.H{"error": err.Error()})
		return
	}

	ctx.JSON(http.StatusCreated, task)

}
