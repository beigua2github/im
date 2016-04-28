package com.starsea.im.aggregation.util;

import com.starsea.im.aggregation.po.News;
import com.starsea.im.aggregation.po.NewsMessage;
import com.starsea.im.aggregation.po.TextMessage;
import com.thoughtworks.xstream.XStream;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by danny on 16/3/29.
 */
public class MessageUtil {
    public static final String MESSAGE_TEXT = "text";
    public static final String MESSAGE_IMAGE = "image";
    public static final String MESSAGE_NEWS = "news";
    public static final String MESSAGE_VOICE = "voice";
    public static final String MESSAGE_VIDEO = "video";
    public static final String MESSAGE_LINK = "link";
    public static final String MESSAGE_LOCATION = "location";
    public static final String MESSAGE_EVENT = "event";
    public static final String MESSAGE_SUBSCRIBE = "subscribe";
    public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
    public static final String MESSAGE_CLICK = "CLICK";
    public static final String MESSAGE_VIEW = "VIEW";

    /*
     * xml转为map集合
     */
    public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException,DocumentException {
        Map<String, String> map = new HashMap<String,String>();
        SAXReader reader = new SAXReader();

        InputStream ins = request.getInputStream();
        org.dom4j.Document doc = reader.read(ins);

        Element root = doc.getRootElement();

        java.util.List<Element> list = root.elements();

        for(Element e : list){
            map.put(e.getName(), e.getText());
        }
        ins.close();
        return map;
    }

    /*
     * 将文本消息对象转为XML
     */
    public static String textMessageToXml(TextMessage textMessage){
        XStream xstream = new XStream();
        xstream.alias("xml",textMessage.getClass());
        return xstream.toXML(textMessage);
    }

    /*
     * 将图文消息对象转为XML
     */
    public static String newsMessageToXml(NewsMessage newsMessage){
        XStream xstream = new XStream();
        xstream.alias("xml",newsMessage.getClass());
        xstream.alias("item",new News().getClass());
        return xstream.toXML(newsMessage);
    }

    /*
     * 拼接图文消息
     */
    public static String initNewsMessage(String toUserName,String fromUserName) {
        String message = null;
        java.util.List<News> newsList= new ArrayList<News>();
        NewsMessage newsMessage = new NewsMessage();

        News news = new News();
        news.setTitle("裔家E+网介绍");
        news.setDescription("裔家E+网课程涵盖前端开发、PHP、Html5、Android、iOS、Swift等IT前沿技术语言，包括基础课程、实用案例、高级分享三大类型，适合不同阶段的学习人群。以纯干货、短视频的形式为平台特点，为在校学生、职场白领提供了一个迅速提升技能、共同分享进步的学习平台。");
        news.setPicUrl("http://etscript.tunnel.qydev.com/Weixin/image/imooc.jpg");
        news.setUrl("www.imooc.com");

        News news1 = new News();
        news1.setTitle("裔家E+网介绍");
        news1.setDescription("裔家E+网课程涵盖前端开发、PHP、Html5、Android、iOS、Swift等IT前沿技术语言，包括基础课程、实用案例、高级分享三大类型，适合不同阶段的学习人群。以纯干货、短视频的形式为平台特点，为在校学生、职场白领提供了一个迅速提升技能、共同分享进步的学习平台。");
        news1.setPicUrl("http://etscript.tunnel.qydev.com/Weixin/image/imooc.jpg");
        news1.setUrl("www.imooc.com");

        newsList.add(news);
        newsList.add(news1);
        newsMessage.setToUserName(fromUserName);
        newsMessage.setFromUserName(toUserName);
        newsMessage.setCreateTime(new Date().getTime());
        newsMessage.setMsgType(MESSAGE_NEWS);
        newsMessage.setArticles(newsList);
        newsMessage.setArticleCount(newsList.size());

        message = newsMessageToXml(newsMessage);
        return message;
    }


    /*
     * 拼接文本消息
     */
    public static String initText(String toUserName,String fromUserName,String content) {
        TextMessage text = new TextMessage();
        text.setFromUserName(toUserName);
        text.setToUserName(fromUserName);
        text.setMsgType(MessageUtil.MESSAGE_TEXT);
        text.setCreateTime(new Date().getTime());
        text.setContent(content);
        return MessageUtil.textMessageToXml(text);
    }

    /*
     * 主菜单
     */
    public static String menuText(){
        StringBuffer sb = new StringBuffer();
        sb.append("欢迎你的关注，请按菜单提示进行操作：\n\n");
        sb.append("1、课程介绍\n");
        sb.append("2、裔家E+网介绍\n");
        sb.append("3、回复？调出菜单。");

        return sb.toString();
    }

    /*
     * 课程介绍
     */
    public static String firstMenu(){
        StringBuffer sb = new StringBuffer();
        sb.append("本套课程介绍微信公众号开发，涉及公众号开发。\n");
        return sb.toString();
    }

    /*
     * 慕课网介绍
     */
    public static String secondMenu(){
        StringBuffer sb = new StringBuffer();
        sb.append("裔家E+网课程涵盖前端开发、PHP、Html5、Android、iOS、Swift等IT前沿技术语言，包括基础课程、实用案例、高级分享三大类型，适合不同阶段的学习人群。以纯干货、短视频的形式为平台特点，为在校学生、职场白领提供了一个迅速提升技能、共同分享进步的学习平台。\n");

        return sb.toString();
    }

}
