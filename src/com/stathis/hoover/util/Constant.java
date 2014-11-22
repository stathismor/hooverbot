package com.stathis.hoover.util;

public class Constant {
    
    public enum Error {
        ERROR_OK (""),
        ERROR_MAP_IS_NOT_SQUARE ("X and y dimensions of the map are different."),
        ERROR_POSITION_IS_OUT_OF_MAP_BOUNDS ("Position is out of map bounds");

        private final String description;       

        private Error(String description) {
            this.description = description;
        }

        public boolean equalsName(String otherName){
            return (otherName == null) ? false : description.equals(otherName);
        }

        public String toString(){
           return description;
        }
    }
}
