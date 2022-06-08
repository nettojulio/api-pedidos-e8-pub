package e8ilab2.apipedidos.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageableUtils {

    public static Pageable showRoom(Integer page, Integer size) {
        page = page == null ? 0 : page;
        size = size == null ? 10 : size;
        Pageable simpleShowElements = PageRequest.of(page, size);
        return simpleShowElements;
    }

    public static Pageable sortedShowRoom(Integer page, Integer size, String properties, Boolean descending) {
        Pageable sortedShowElements;
        page = page == null ? 0 : page;
        size = size == null ? 10 : size;
        properties = properties == null ? "id" : properties;
        descending = descending == null ? true : false;

        if (!descending) {
            sortedShowElements = PageRequest.of(page, size, Sort.by(properties).descending());
        } else {
            sortedShowElements = PageRequest.of(page, size, Sort.by(properties));
        }
        return sortedShowElements;
    }

}
