package service;

import beans.ContentsInfoBean;
import beans.MemberInfoBean;
import beans.PagingBean;
import dao.BoardDAO;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class BoardService {

    @Value("${path.upload}")
    private String path_upload;

    @Value("${page.listcnt}")
    private int page_listcnt;

    @Value("${page.paginationcnt}")
    private int page_paginationcnt;

    @Autowired
    private BoardDAO boardDAO;

    @Resource(name = "loginMemberBean")
    private MemberInfoBean loginMemberBean;

    private String saveUploadFile(MultipartFile upload_file) {
        String file_name = System.currentTimeMillis() + "_" + upload_file.getOriginalFilename();

        try {
            upload_file.transferTo(new File(path_upload + "/" + file_name));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return file_name;
    }

    public void addContentInfoBean(ContentsInfoBean writeContentBean) {

        MultipartFile upload_file = writeContentBean.getUpload_file();

        if (upload_file.getSize() > 0) {
            String file_name = saveUploadFile(upload_file);
            writeContentBean.setContent_file(file_name);
        }

        writeContentBean.setContent_writer_idx(loginMemberBean.getUser_idx());
        boardDAO.addContentInfo(writeContentBean);

    }

    public String getBoardInfoName(int board_info_idx) {
        return boardDAO.getBoardInfoName(board_info_idx);
    }

    public List<ContentsInfoBean> getContentBean(int board_info_idx, int page) {
        int start = (page - 1) * page_listcnt;
        RowBounds rowBounds = new RowBounds(start, page_listcnt);

        return boardDAO.getContentBean(board_info_idx, rowBounds);
    }

    public ContentsInfoBean getContentInfo(int content_idx) {
        return boardDAO.getContentInfo(content_idx);
    }

    public void modifyContentInfo(ContentsInfoBean modifyContentBean) {

        MultipartFile upload_file = modifyContentBean.getUpload_file();

        // 업로드한 파일이 있을 경우 덮어쓴다.
        if (upload_file.getSize() > 0) {
            String file_name = saveUploadFile(upload_file);
            modifyContentBean.setContent_file(file_name);
        }

        boardDAO.modifyContentInfo(modifyContentBean);
    }

    public void removeContentInfo(int content_idx) {

        boardDAO.removeContentInfo(content_idx);

    }

    public PagingBean getContentCnt(int content_board_idx, int currPage) {

        int content_cnt = boardDAO.getContentCnt(content_board_idx);

        return new PagingBean(content_cnt, currPage, page_listcnt, page_paginationcnt);
    }

}
