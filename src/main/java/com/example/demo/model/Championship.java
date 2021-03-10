package com.example.demo.model;

import java.util.Date;
import java.util.List;

public class Championship {
        private String name;
        private Date initialDate;
        private Date finalDate;
        private List<Score> table;

        public String getName() {
                return name;
        }
        public void setName(String name) {
                this.name = name;
        }
        public Date getInitialDate() {
                return initialDate;
        }
        public void setInitialDate(Date initialDate) {
                this.initialDate = initialDate;
        }
        public Date getFinalDate() {
                return finalDate;
        }
        public void setFinalDate(Date finalDate) {
                this.finalDate = finalDate;
        }
        public List<Score> getTable() {
                return table;
        }
        public void setTable(List<Score> table) {
                this.table = table;
        }
}
