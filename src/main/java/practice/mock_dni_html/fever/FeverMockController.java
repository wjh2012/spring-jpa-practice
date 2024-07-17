package practice.mock_dni_html.fever;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/fever")
public class FeverMockController {

    //    private static final String FILE_PATH = "/Users/WONJANGHO/Desktop/test/";
    private static final String FILE_PATH = "/Users/wjh20/Desktop/test/";

    @PostMapping("/rts/rules/{ruleId}/execute-wtg")
    public DtoWrapper downloadFile(@PathVariable String ruleId, @RequestBody Object object) {
        DtoWrapper dtoWrapper = makeData();
        log.info(dtoWrapper.toString());
        return dtoWrapper;
    }

    private DtoWrapper makeData() {
        List<ItemActionDto> itemActions = new ArrayList<>();

        // Create work items
        WorkItemDto workItem1 = new WorkItemDto();
        workItem1.setObjItmId("cmn_cust_name");
        workItem1.setObjItmNm("성명");
        workItem1.setReqdYn("false");
        workItem1.setDsblYn("false");
        workItem1.setLckYn("N");
        workItem1.setHidnYn("N");
        workItem1.setUdcYn("N");
        workItem1.setAiYn("N");
        workItem1.setDataLength(0);
        workItem1.setNewlineDelYn("N");
        workItem1.setItmActs(itemActions);

        WorkItemDto workItem2 = new WorkItemDto();
        workItem2.setObjItmId("new_custinfo_home_addr_sign");
        workItem2.setObjItmNm("자택주소");
        workItem2.setReqdYn("N");
        workItem2.setDsblYn("false");
        workItem2.setLckYn("N");
        workItem2.setHidnYn("N");
        workItem2.setUdcYn("N");
        workItem2.setAiYn("N");
        workItem2.setDataLength(0);
        workItem2.setNewlineDelYn("N");
        workItem2.setItmActs(itemActions);

        // Create target item mappings
        WorkTargetItemMappingDto mappingDto = new WorkTargetItemMappingDto();
        mappingDto.setSendObjItmId("cmn_brdd");
        mappingDto.setRecvObjId("A2023062");
        mappingDto.setRecvObjItmId("a2023062_col003_input");

        // Another mapping
        WorkTargetItemMappingDto mappingDto2 = new WorkTargetItemMappingDto();
        mappingDto2.setSendObjItmId("cmn_cust_name");
        mappingDto2.setRecvObjId("A2023063");
        mappingDto2.setRecvObjItmId("a2023063_col001_signgroup");

        // Create work target response
        WorkTargetResponseDto responseDto1 = new WorkTargetResponseDto();
        responseDto1.setObjId("IBK1000");
        responseDto1.setObjNm("기업은행 단말화면");
        responseDto1.setChId("01");
        responseDto1.setSortOrd(0);
        responseDto1.setWrkItms(Arrays.asList(workItem1, workItem2));
        responseDto1.setWrkTrgItmMapps(Arrays.asList(mappingDto, mappingDto2));

        // Create a second work target response, to reflect multiple entries as in your original data
        WorkTargetResponseDto responseDto2 = new WorkTargetResponseDto();
        responseDto2.setObjId("A2023062");
        responseDto2.setObjNm("1번 필수 개인(신용)정보 수집ㆍ이용 동의서(비여신금융거래)");
        responseDto2.setChId("02");
        responseDto2.setSortOrd(1);
        responseDto2.setWrkItms(
            new ArrayList<>());  // assuming no items defined for this one in the sample
        responseDto2.setWrkTrgItmMapps(new ArrayList<>());

        // Root DTO
        RootDto rootDto = new RootDto();
        rootDto.setRtsWrkTrgResponses(Arrays.asList(responseDto1, responseDto2));

        DtoWrapper dtoWrapper = new DtoWrapper();
        dtoWrapper.set_embedded(rootDto);

        return dtoWrapper;
    }


    @Data
    public static class DtoWrapper {

        private RootDto _embedded;

    }

    @Data
    public static class RootDto {

        private List<WorkTargetResponseDto> rtsWrkTrgResponses;

    }

    @Data
    public static class WorkTargetResponseDto {

        private String objId;
        private String objNm;
        private String chId;
        private String reprYn;
        private String reqdYn;
        private String invPrdYn;
        private int sortOrd;
        private List<WorkItemDto> wrkItms;
        private List<WorkTargetItemMappingDto> wrkTrgItmMapps;
        private String workListFilePath;

    }

    @Data
    public static class WorkItemDto {

        private String objItmId;
        private String objItmNm;
        private String reqdYn;
        private String bscVal;
        private String dsblYn;
        private String lckYn;
        private String hidnYn;
        private String meta;
        private String udcYn;
        private String aiYn;
        private String cmpTyp;
        private String cdId;
        private String wrtgMabd;
        private String datDataTgb;
        private String imemode;
        private String dataPattern;
        private String dataType;
        private int dataLength;
        private String newlineDelYn;
        private List<ItemActionDto> itmActs;

    }

    @Data
    public static class ItemActionDto {

    }

    @Data
    public static class WorkTargetItemMappingDto {

        private String sendObjItmId;
        private String recvObjId;
        private String recvObjItmId;
        private String recvObjItmVal;
        private List<ItemTranslationDto> itmTrls;

    }

    @Data
    public static class ItemTranslationDto {

    }

}
