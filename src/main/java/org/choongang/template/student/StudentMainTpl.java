package org.choongang.template.student;

import org.choongang.template.Template;
import org.choongang.template.Templates;

public class StudentMainTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("             <학생관리>\n");
        sb.append("           1. 학생 등록\n");
        sb.append("           2. 학생 조회\n");
        sb.append("           3. 메인 메뉴\n");
        sb.append(Templates.getInstance().line());

        return sb.toString();
    }
}

/**
 * 학생 관리 메뉴에 대한 템플릿을 정의하는 StudentMainTpl 클래스입니다.
 *
 * getTpl() : 템플릿을 반환하는 메서드
 * 문자열 버퍼를 사용하여 여러 줄의 텍스트 생성, 그 안에 학생 관리 메뉴에 대한 정보 추가
 * Templates.getInstance().line()을 통해 구분선을 추가하여 시각적으로 명확하게 메뉴 구분
 */