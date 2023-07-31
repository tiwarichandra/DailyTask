public class StudentProxy extends Student {


    public StudentProxy(Attendance attendance) {
        super(attendance);
    }

    @Override
    public void attendSession() {

        if (super.getAttendance().isPresent()) {
            super.attendSession();
        } else {
            throw new RuntimeException("Student is not present and can't attend the lesson");
        }

    }
}
