package br.com.ms.b.feignClient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "ms-auth-and-auto", url = "http://localhost:8080/ms-auth-and-auto/")
public interface MsAuthAndAutoFeign {
}
