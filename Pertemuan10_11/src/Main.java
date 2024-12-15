package Pertemuan10_11.src;
import org.apache.ibatis.session.SqlSession;

import Pertemuan10_11.src.Model.MyBatisUtil;
import Pertemuan10_11.src.Model.UserMapper;
import Pertemuan10_11.src.View.UserView;
import Pertemuan10_11.src.Controller.UserController;

public class Main {
  public static void main(String[] args) {
    SqlSession session = MyBatisUtil.getSqlSession();
    UserMapper mapper = session.getMapper(UserMapper.class);

    UserView view = new UserView();
    new UserController(view, mapper);

    view.setVisible(true);
  }
}