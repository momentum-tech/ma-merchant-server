package com.mmnttech.ma.merchant.server.service;

/**
 * @author Stelo
 * @createAt 2018/1/13
 **/

import com.mmnttech.ma.merchant.server.BootApplication;
import com.mmnttech.ma.merchant.server.common.dto.MerchantDto;
import com.mmnttech.ma.merchant.server.common.exception.DatabaseException;
import com.mmnttech.ma.merchant.server.mapper.MerchantMapper;
import com.mmnttech.ma.merchant.server.model.*;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest(classes = BootApplication.class)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MerchantServiceTest {

    @InjectMocks
    private MerchantService merchantService;

    @Mock
    private MerchantMapper merchantMapper;

    @Mock
    private AttachService attachService;

    @Mock
    private TaskService taskService;

    @Mock
    private MerchantCertService merchantCertService;

    @Mock
    private RoleService roleService;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    private MerchantDto setValue() {
        MerchantDto merchantDto = new MerchantDto();
        Merchant merchant = new Merchant();
        merchant.setAddressCoorX(new BigDecimal(1));
        merchant.setAddressCoorY(new BigDecimal(2));
        merchant.setAreaCode("test");
        merchant.setAuthReason("test");
        merchant.setAuthStep("1");
        merchant.setCategoryCode("test");
        merchant.setClrAct("1");
        merchant.setComMemo("test");
        merchant.setComStat("1");
        merchant.setCpyAddress("test");
        merchant.setCpyLegalName("test");
        merchant.setCpyName("test");
        merchant.setIdCardNo("test");
        merchant.setIndustryCode("test");
        merchant.setIntroduction("test");
        merchant.setLinkman("test");
        merchant.setLicenseNo("test");
        merchant.setSpecial("test");
        merchant.setStat("1");
        merchant.setSvrTel("test");
        List<Attach> attachList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Attach attach = new Attach();
            attach.setAttachUrl(String.valueOf(i) + ".jpg");
            attach.setComMemo("test");
            attach.setName("test" + String.valueOf(i));
            attach.setSeriNo(i);
            attach.setType(String.valueOf(i));
            attachList.add(attach);
        }
        merchantDto.setMerchant(merchant);
        merchantDto.setAttachList(attachList);
        return merchantDto;
    }

    @Test
    public void test1create1() {
        MerchantDto exceptedObj = setValue();
        List<Task> taskList = new LinkedList<>();
        taskList.add(new Task());
        List<MerchantCert> merchantCertList = new LinkedList<>();
        MerchantCert merchantCert = new MerchantCert();
        merchantCert.setRoleId("test");
        merchantCertList.add(merchantCert);
        when(merchantMapper.insert(any(Merchant.class))).thenReturn(1);
        when(attachService.createAll(anyList(), anyString())).thenReturn(true);
        when(attachService.findByMasterId(anyString())).thenReturn(exceptedObj.getAttachList());
        when(taskService.createTaskList(anyList())).thenReturn(taskList);
        when(merchantCertService.queryMerchantCertByAreaCodeAndIndustryCode(anyString(), anyString())).thenReturn(merchantCertList);
        when(roleService.queryRoleById(anyString())).thenReturn(new Role());
        MerchantDto merchantDto = merchantService.createMerchant(exceptedObj);
        Assert.assertEquals(exceptedObj.getMerchant().getAddressCoorX(), merchantDto.getMerchant().getAddressCoorX());
        Assert.assertEquals(exceptedObj.getMerchant().getComMemo(), merchantDto.getMerchant().getComMemo());
        for (int i = 0; i < 5; i++) {
            Assert.assertEquals(exceptedObj.getAttachList().get(i).getAttachUrl(), merchantDto.getAttachList().get(i).getAttachUrl());
            Assert.assertEquals(exceptedObj.getAttachList().get(i).getType(), merchantDto.getAttachList().get(i).getType());
        }
    }

    @Test
    public void test1create2() {
        MerchantDto exceptedObj = setValue();
        when(merchantMapper.insert(any(Merchant.class))).thenReturn(0);
        when(attachService.createAll(anyList(), anyString())).thenReturn(true);
        when(attachService.findByMasterId(anyString())).thenReturn(exceptedObj.getAttachList());
        expectedException.expect(DatabaseException.class);
        expectedException.expectMessage("error.merchant.insert");
        MerchantDto merchantDto = merchantService.createMerchant(exceptedObj);
    }

    @Test
    public void test1create3() {
        MerchantDto exceptedObj = setValue();
        when(merchantMapper.insert(any(Merchant.class))).thenReturn(1);
        when(attachService.createAll(anyList(), anyString())).thenReturn(false);
        when(attachService.findByMasterId(anyString())).thenReturn(exceptedObj.getAttachList());
        expectedException.expect(DatabaseException.class);
        expectedException.expectMessage("error.merchant.insert");
        MerchantDto merchantDto = merchantService.createMerchant(exceptedObj);
    }

    @Test
    public void test2query1() {
        String queryId = "id";
        MerchantDto exceptedObj = setValue();
        when(merchantMapper.selectByPrimaryKey(queryId)).thenReturn(exceptedObj.getMerchant());
        Merchant merchant = merchantService.queryMerchantById(queryId);
        Assert.assertEquals(exceptedObj.getMerchant().getComMemo(), merchant.getComMemo());
        Assert.assertEquals(exceptedObj.getMerchant().getAuthStep(), merchant.getAuthStep());
        Assert.assertEquals(exceptedObj.getMerchant().getCategoryCode(), merchant.getCategoryCode());
    }

    @Test
    public void test2query2() {
        String queryId = "id";
        MerchantDto exceptedObj = setValue();
        when(merchantMapper.selectByPrimaryKey(queryId)).thenReturn(exceptedObj.getMerchant());
        when(attachService.findByMasterId(queryId)).thenReturn(exceptedObj.getAttachList());
        MerchantDto merchantDto = merchantService.queryMerchantDetailInfoById(queryId);
        Assert.assertEquals(exceptedObj.getMerchant().getAddressCoorX(), merchantDto.getMerchant().getAddressCoorX());
        Assert.assertEquals(exceptedObj.getMerchant().getComMemo(), merchantDto.getMerchant().getComMemo());
        for (int i = 0; i < 5; i++) {
            Assert.assertEquals(exceptedObj.getAttachList().get(i).getAttachUrl(), merchantDto.getAttachList().get(i).getAttachUrl());
            Assert.assertEquals(exceptedObj.getAttachList().get(i).getType(), merchantDto.getAttachList().get(i).getType());
        }
    }
}
