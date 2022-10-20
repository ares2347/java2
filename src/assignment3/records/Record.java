package assignment3.records;

public class Record {
    public Integer id;
    public Integer qty;
    public Integer bookId;
    public String studentId;

    public Record(Integer id, Integer qty, Integer bookId, String studentId) {
        this.id = id;
        this.qty = qty;
        this.bookId = bookId;
        this.studentId = studentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
