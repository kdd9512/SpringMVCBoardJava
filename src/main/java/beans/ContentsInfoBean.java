package beans;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;

public class ContentsInfoBean {

    // 테이블 구조와 동일한 Bean 을 정의한다.

    private int content_idx;
    @NotBlank // 비어있으면 오류 발생시키는 annotation.
    private String content_subject;
    @NotBlank // 비어있으면 오류 발생시키는 annotation.
    private String content_text;

    // content_file 은 return 값이 String 인데,
    // 업로드 하는 file 이 String 일 수가 없으므로 오류가 발생할 것이다. 그러므로 용도를 둘로 나눈다.
    // 1. content_file 은 파일의 이름을 담는다.
    // 2. upload_file 는 실제 파일의 정보를 담는다.
    private MultipartFile upload_file;
    private String content_file;
    private int content_writer_idx;
    private int content_board_idx;
    private String content_date;

    public ContentsInfoBean() {
    }

    public ContentsInfoBean(int content_idx, String content_subject,
                            String content_text, String content_file,
                            int content_writer_idx, int content_board_idx,
                            String content_date) {
        this.content_idx = content_idx;
        this.content_subject = content_subject;
        this.content_text = content_text;
        this.content_file = content_file;
        this.content_writer_idx = content_writer_idx;
        this.content_board_idx = content_board_idx;
        this.content_date = content_date;
    }

    public int getContent_idx() {
        return content_idx;
    }

    public void setContent_idx(int content_idx) {
        this.content_idx = content_idx;
    }

    public String getContent_subject() {
        return content_subject;
    }

    public void setContent_subject(String content_subject) {
        this.content_subject = content_subject;
    }

    public String getContent_text() {
        return content_text;
    }

    public void setContent_text(String content_text) {
        this.content_text = content_text;
    }

    public String getContent_file() {
        return content_file;
    }

    public void setContent_file(String content_file) {
        this.content_file = content_file;
    }

    public int getContent_writer_idx() {
        return content_writer_idx;
    }

    public void setContent_writer_idx(int content_writer_idx) {
        this.content_writer_idx = content_writer_idx;
    }

    public int getContent_board_idx() {
        return content_board_idx;
    }

    public void setContent_board_idx(int content_board_idx) {
        this.content_board_idx = content_board_idx;
    }

    public String getContent_date() {
        return content_date;
    }

    public void setContent_date(String content_date) {
        this.content_date = content_date;
    }

    public MultipartFile getUpload_file() {
        return upload_file;
    }

    public void setUpload_file(MultipartFile upload_file) {
        this.upload_file = upload_file;
    }
}
