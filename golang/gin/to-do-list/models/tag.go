package models

import (
	"fmt"

	"github.com/nuttapat/gin-todo/services/postgresql"
	"gorm.io/gorm"
)

type Tag struct {
	gorm.Model
	Title string `json:"title"`
	Color string `json:"color"`
}

func GetTagByIDs(tagIDs []int) (tags []Tag, err error) {
	db := postgresql.GetDB()

	if err = db.Find(&tags, tagIDs).Error; err != nil {
		// Handle error
		fmt.Println("Couldn't find")
		return
	}
	return
}
