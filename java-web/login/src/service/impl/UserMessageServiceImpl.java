package service.impl;

import com.mysql.jdbc.StringUtils;
import dao.UserMessageDao;
import dao.impl.UserMessageDaoImpl;
import domain.PageBean;
import domain.UserMessage;
import service.UserMessageService;

import java.util.*;

/**
 * @author 无名氏
 * @Data 2021/7/2
 */
public class UserMessageServiceImpl implements UserMessageService {
    UserMessageDao userMessageDao = new UserMessageDaoImpl();

    @Override
    public void addUserMessage(UserMessage userMessage) {
        if (userMessageDao.isUserMessageExist(userMessage.getId())) {
            userMessageDao.setUserMessage(userMessage);
        } else {
            userMessageDao.addUserMessage(userMessage);
        }
    }

    @Override
    public void deleteUserMessage(int[] id) {
        for (int i = 0; i < id.length; i++) {
            //不用判断是否存在id(userMessageList.jsp的id一定存在,且不存在也不会出现错误)
            userMessageDao.deleteUserMessage(id[i]);
        }
    }

    @Override
    public UserMessage searchUserMessage(int id) {
        return userMessageDao.searchUserMessage(id);
    }

    @Override
    public PageBean<UserMessage> searchUsersMessageByPage(String currentPage, String rows, Map<String, String[]> condition) {
        int cp;
        int row;
        if (StringUtils.isNullOrEmpty(currentPage)) {
            cp = 1;
        } else {
            cp = Integer.parseInt(currentPage);
        }

        if (StringUtils.isNullOrEmpty(rows)) {
            row = 10;
        } else {
            row = Integer.parseInt(rows);
        }
        Map<String, Object[]> translate = translate(condition);
//        System.out.println(Arrays.deepToString(translate));
        PageBean<UserMessage> pageBean = new PageBean<>(cp, row);
        pageBean.setRows(row);
        int i = userMessageDao.searchUserMessageCount(translate);
        pageBean.setTotalCount(i);
        double totalCount = (double) i;
        int totalPage = (int) Math.ceil(totalCount / row);
        pageBean.setTotalPage(totalPage);
        if (totalPage < cp) {
            cp = totalPage;
        }
        if (cp <= 0) {
            cp = 1;
        }
        pageBean.setCurrentPage(cp);
        int start = row * (cp - 1);
        List<UserMessage> userMessages = userMessageDao.searchUsersMessageByPage(start, row,translate);
        pageBean.setList(userMessages);
        return pageBean;
    }

    private Map<String, Object[]> translate(Map<String, String[]> condition) {
        List<String> param = new ArrayList<String>();
        StringBuilder sql = new StringBuilder();
        String[] name = condition.get("name");
        if (name!=null && name.length>0 && !StringUtils.isNullOrEmpty(name[0])) {
            sql.append(" and  name like ?");
            param.add("%" + name[0] + "%");
        }

        String[] tel = condition.get("tel");
        if (tel!=null && tel.length>0 && !StringUtils.isNullOrEmpty(tel[0])) {
            sql.append(" and  tel like ?");
            param.add("%" + tel[0] + "%");
        }
        String[] e_mail = condition.get("e_mail");
        if (e_mail!=null && e_mail.length>0 && !StringUtils.isNullOrEmpty(e_mail[0])) {
            sql.append(" and  e_mail like ?");
            param.add("%" + e_mail[0] + "%");
        }
        Map<String, Object[]> map = new HashMap<>();
        map.put(sql.toString(),param.toArray());
        return map;
    }

/*    private String[][] translate2(Map<String, String[]> condition){
        List<String> param = new ArrayList<String>();
        StringBuilder key = new StringBuilder();
        Set<String> keySet = condition.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            String k = iterator.next();
            if ("currentPage".equals(k) || k.equals("rows")){
                continue;
            }
            String v = condition.get(k)[0];
            if (!StringUtils.isNullOrEmpty(v)) {
                key.append(" and " + k + " like ?");
                param.add("%"+v+"%");
            }
        }
        String[][] s = new String[2][2];
        s[0][0] = key.toString();
        s[1] = (String[]) param.toArray();
        return s;
    }*/
}
