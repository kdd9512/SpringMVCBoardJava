package beans;

public class PagingBean {

    // 최소 페이지 번호
    private int min;
    // 최대 페이지 번호
    private int max;
    // 이전 페이지 번호
    private int prevPage;
    // 다음 페이지 번호
    private int nextPage;
    // 현재 페이지 번호
    private int currPage;
    // 전체 페이지 개수
    private int pageCnt;


    // contentCnt = 전체 글 개수, currPage = 현재 글 번호, contentPageCnt = 페이지당 글 개수, paginationCnt = 페이지 버튼 개수
    public PagingBean(int contentCnt, int currPage, int contentPageCnt, int paginationCnt) {
        // 현재 페이지 번호
        this.currPage = currPage;

        // 전체 페이지 개수 = 전체 글 개수 / 페이지 당 글 개수.
        pageCnt = contentCnt / contentPageCnt;
        // 만약 페이지 개수가 짝수가 아니라면 나머지 페이지를 띄우기 위해 전체 페이지 개수를 하나 증가시킴.
        if (contentCnt % contentPageCnt > 0) {
            pageCnt++;
        }
        // 페이지 버튼 개수를 결정한다.
        // 1. 최소값은 1이며 최대값은 10단위가 되어야 한다(1~10, 11~20, 21~30 ...)
        // 2. 시스템 상에서 페이지의 시작은 0이므로 현재 페이지 번호에서 -1 을 한 뒤(-> 0~9 : 페이지1, 10~19 : 페이지 11, 20~29 : 페이지 21),
        //    페이지당 글의 개수로 나눈다(페이지1 : 0, 페이지10 : 11, 페이지20 : 21).
        // 3. 2번에서 구한 값에 페이지 당 글의 개수를 곱하고 그 값에 1을 더한다.
        min = ((currPage - 1) / contentPageCnt) * contentPageCnt + 1;
        max = min + paginationCnt - 1;

        if (max > pageCnt) {
            max = pageCnt;
        }

        prevPage = min - 1;
        nextPage = max + 1;

        // 마지막 페이지 제한. 다음 페이지 값이 더 커지는 것을 방지함.
        if (nextPage > pageCnt) {
            nextPage = pageCnt;
        }

    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getPrevPage() {
        return prevPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public int getCurrPage() {
        return currPage;
    }

    public int getPageCnt() {
        return pageCnt;
    }
}
