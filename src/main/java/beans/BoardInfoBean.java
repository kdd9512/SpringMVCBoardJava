package beans;

public class BoardInfoBean {

    // 테이블 구조와 동일한 Bean 을 정의한다.
    private int board_info_idx;
    private String board_info_name;

    public int getBoard_info_idx() {
        return board_info_idx;
    }

    public void setBoard_info_idx(int board_info_idx) {
        this.board_info_idx = board_info_idx;
    }

    public String getBoard_info_name() {
        return board_info_name;
    }

    public void setBoard_info_name(String board_info_name) {
        this.board_info_name = board_info_name;
    }
}
