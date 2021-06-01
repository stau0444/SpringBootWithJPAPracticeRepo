package com.practice.jpapraticerepo.practice.webMVCprac.wrapper;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;

public class CachedBodyHttpServletRequest extends HttpServletRequestWrapper {
    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request The request to wrap
     * @throws IllegalArgumentException if the request is null
     */
    private byte[] cachedBody;

    public CachedBodyHttpServletRequest(HttpServletRequest request) throws IOException {
        super(request);
        //리퀘스의 인풋 스트림을 가져온다
        InputStream requestInputStream = request.getInputStream();
        //가져온 스트림을 바이트 배열로 복사해 저장한다.
        this.cachedBody = StreamUtils.copyToByteArray(requestInputStream);
    }


   /*
                ServletRequest 인터페이스의 설명에는

              If the parameter data was sent in the request body,
              such as occurs with an HTTP POST request, then reading the body directly via getInputStream
              or getReader can interfere with the execution of this method.
              '매개 변수 데이터가 요청 본문에 전송 된 경우
              HTTP POST 요청으로 발생하고 getInputStream을 통해 직접 본문을 읽습니다.
              또는 getReader가이 메소드의 실행을 방해 할 수 있습니다.'

              getInputStream을 꼭 구현해야 하는 것 같다.


    */

    //인풋 스트림을 얻어오는 메서드
    @Override
    public ServletInputStream getInputStream() throws IOException {
        return new CachedBodyServletInputStream(this.cachedBody);
    }

    //캐싱된 바이트배열로 바이트인풋스트림을 만들고  bufferedReader를 생성해 리턴해주는 메서드
    @Override
    public BufferedReader getReader() throws IOException {
        //저장해놓은 바이트 배열을 가지고 새로운 인풋 스트림을 만든다.
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.cachedBody);
        //BufferedReader로 감싸 리턴한다.
        return new BufferedReader(new InputStreamReader(byteArrayInputStream));
    }




}
