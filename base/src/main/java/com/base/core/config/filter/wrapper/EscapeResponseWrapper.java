package com.base.core.config.filter.wrapper;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class EscapeResponseWrapper extends HttpServletResponseWrapper {


//    private ByteArrayOutputStream baos = null;
//    private ResponseOutputStream ros = null;
//    private String resBody = "";

    public EscapeResponseWrapper(HttpServletResponse response) {
        super(response);
    }

//    @Override
//    public ServletOutputStream getOutputStream() throws IOException {
//
//        if( ros == null )
//        {
//            baos = new ByteArrayOutputStream();
//            ros = new ResponseOutputStream( super.getOutputStream(), baos );
//        }
//
//        if( baos != null )
//        {
//            String sBody = StringUtils.nullToBlank( baos.toString() );
//            if( !"".equals( sBody ) )
//            {
//                System.out.println("baos.toString()["+baos.toString()+"]");
//                resBody = JSONConvert.htmlEscapeToJson( HTML_ESCAPE_TYPE.UN_ESCAPE, baos.toString() ).toJSONString();
//                System.out.println(" resBody ["+resBody+"]");
//
//            }
//        }
//
//        return ros;
//    }
//
//
//    public class ResponseOutputStream extends ServletOutputStream {
//
//        private TeeOutputStream tos;
//
//        public ResponseOutputStream( OutputStream inOs, OutputStream outOs ) {
//            super();
//            tos = new TeeOutputStream( inOs, outOs);
//        }
//
//        @Override
//        public void write(int b) throws IOException {
//            tos.write(b);
//        }
//
//
//        public void flush() throws IOException {
//            super.flush();
//            tos.flush();
//        }
//
//        public void close() throws IOException {
//            super.close();
//            tos.close();
//        }
//
//
//
//    }


}
