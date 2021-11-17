package 责任链模式;

import jdk.nashorn.internal.ir.RuntimeNode;
import jdk.nashorn.internal.ir.VarNode;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: ServletMain
 * @description: 责任链设计模式 javax.servlet包下filter的实现
 * @date 2021-11-01
 */
public class ServletMain {
    interface Filter {
        void doFilter(Request request, Response response, FilterChain filterChain);
    }

    static class Request {
        private String value;

        @Override
        public String toString() {
            return "Request{" +
                    "value='" + value + '\'' +
                    '}';
        }

        public Request(String value) {
            this.value = value;
        }
    }

    static class Response {
        private String value;

        @Override
        public String toString() {
            return "Response{" +
                    "value='" + value + '\'' +
                    '}';
        }

        public Response(String value) {
            this.value = value;
        }
    }

    static class MyFilter implements Filter {

        @Override
        public void doFilter(Request request, Response response, FilterChain filterChain) {
            request.value = request.value.replaceAll("你好", "你好，八戒！");
            System.out.println(request);
            filterChain.doFilter(request, response, filterChain);
            response.value = response.value.replaceAll("你好", "你好，九戒！");
            System.out.println(response);
        }
    }

    static class FilterChain implements Filter {
        List<Filter> filters = new ArrayList<Filter>();
        int index = 0;

        public FilterChain add(Filter filter) {
            filters.add(filter);
            return this;
        }

        @Override
        public void doFilter(Request request, Response response, FilterChain filterChain) {
            if (index == filters.size()) {
                return;
            }
            Filter filter = filters.get(index);
            index++;
            filter.doFilter(request, response, filterChain);
        }
    }

    public static void main(String[] args) {
        FilterChain chain = new FilterChain();
        chain.add(new MyFilter()).add(new MyFilter());
        Request request = new Request("1313,你好");
        Response response = new Response("1313,你好");
        chain.doFilter(request, response, chain);
    }
}
