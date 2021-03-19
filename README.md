[![Quarkus Codestart CI](https://github.com/evimla/soap-and-rest-1/actions/workflows/ci.yml/badge.svg)](https://github.com/evimla/soap-and-rest-1/actions/workflows/ci.yml)

## Testing community extension for SOAP support

minimal code to test out syntax, config and co-living with rest api

### try rest-api with: 
```
curl http://localhost:8080/hello-rest
```
should get:
> hello world

### try soap-api with:
```bash
curl "http://localhost:8080/cxf/hello-soap" \
-H 'Content-Type: text/xml' \
-H 'SOAPAction:' \
-d '
<soapenv:Envelope 
xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
xmlns:cxf="http://cxf.acme.org/">
    <soapenv:Header/>
    <soapenv:Body>
       <cxf:hello/>
    </soapenv:Body>
</soapenv:Envelope>'
```
should get :
> ```
> <soap:Envelope 
> xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
>   <soap:Body>
>       <ns1:helloResponse xmlns:ns1="http://soap.example.org/">
>           <return>Hello</return>
>       </ns1:helloResponse>
>   </soap:Body>
> </soap:Envelope>
> ```

### try openapi-swagger-ui with:
http://localhost:8080/q/swagger-ui

