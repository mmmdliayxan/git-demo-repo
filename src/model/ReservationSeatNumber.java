package model;

public class ReservationSeatNumber {

        private int setNumber;

        public int getSetNumber() {
            return setNumber;
        }

        public void setSetNumber(int setNumber) {
            this.setNumber = setNumber;
        }

        public ReservationSeatNumber (int setNumber){
            this.setNumber = setNumber;

        }

        @Override
        public String toString(){
            return "seat number :" + setNumber;
        }
    }

