package service;

import beans.ContentsInfoBean;
import beans.MemberInfoBean;
import dao.BoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.File;
import java.util.List;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class BoardService {

    @Value("${path.upload}")
    private String path_upload;

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

    public List<ContentsInfoBean> getContentBean (int board_info_idx) {
        return boardDAO.getContentBean(board_info_idx);
    }

}
