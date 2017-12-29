package com.nanyin.ap.service.serviceImpl;

import com.nanyin.ap.mapper.SalesorderMapper;
import com.nanyin.ap.model.Client;
import com.nanyin.ap.model.Ex.SalesOrderEx;
import com.nanyin.ap.model.Parts;
import com.nanyin.ap.model.Salesorder;
import com.nanyin.ap.model.Users;
import com.nanyin.ap.model.vo.SalesOrderVo;
import com.nanyin.ap.service.ClientService;
import com.nanyin.ap.service.PartsService;
import com.nanyin.ap.service.SalesorderService;
import com.nanyin.ap.service.UsersService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author nanyin
 * @time 下午12:14
 * @name SalesorderServiceImpl
 * @description
 */
@Service
public class SalesorderServiceImpl implements SalesorderService{

    @Autowired
    SalesorderMapper salesorderMapper;
    @Autowired
    UsersService usersService;
    @Autowired
    ClientService clientService;
    @Autowired
    PartsService partsService;


    /**
     *
     * @param pageNum
     * @param interval
     * @return
     */
    @Override
    public Map<String, Object> salesOrdersLimit(int pageNum, String interval) {

        int limit = 10 ;
        int inter = 0;

        Map<String,Object> map = new HashMap<>();
        List<Salesorder> list = new LinkedList<>();

        if(interval != null && !"".equals(interval)) {
            inter = Integer.parseInt(interval);
            //获得当前时间
            Timestamp now = new Timestamp(System.currentTimeMillis());
            //转换成data类型进项时间的加减
            Date nowDate = new Date();
            try {
                nowDate = now;
            } catch (Exception e) {
                e.printStackTrace();
            }
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(nowDate);
            calendar.add(calendar.DATE, -inter);
            Date afterAdd = calendar.getTime();
            // 转化为timestamps类型
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String afterAddString = simpleDateFormat.format(afterAdd);
            Timestamp end = Timestamp.valueOf(afterAddString);
            // 几天前的时间 end
            list = salesorderMapper.findSaleOrders((pageNum - 1) * limit,limit,now,end);
        } else {
            list = salesorderMapper.findSaleOrders((pageNum - 1) * limit,limit,null,null);
        }
        // 在这里进行格式转化
        List<SalesOrderVo> newList = setValue(list);


        int count = newList.size();
        map.put("code",0);
        map.put("mes","");
        map.put("count",count);
        map.put("data",newList);
        map.put("pageNum",pageNum);
        return map;
    }

    @Override
    public int DeleteSalesOrdersById(int id) {
        return salesorderMapper.DeleteSaleOrdersById(id);
    }

    @Override
    public SalesOrderEx findAllMesOfSales(int id) {
        Salesorder salesorder = salesorderMapper.findSaleOrderById(id);
        return setValue(salesorder);
    }

    /**
     *
     * @param id
     * @param sId
     * @param sNumber
     * @param sPay
     * @param sClientName
     * @param sketch

     * @return
     */
    @Override
    public int updateSaleOrders(int id, String sId,
                                String sNumber,
                                String sPay,
                                String sUserName,
                                String sClientName,
                                String sketch
                                ) {
        int partId = Integer.parseInt(sId);
        int number = Integer.parseInt(sNumber);

        Client client = clientService.findClientByClientName(sClientName);

        Users users = usersService.findUserByName(sUserName);

        return salesorderMapper.updateSaleOrderById(id,number,partId,sketch,users.getId(),client.getId(),sPay);
    }

    /**
     * 新建销售单信息
     * @param sId
     * @param sNumber
     * @param sPay
     * @param client
     * @param sketch
     * @return
     */
    @Override
    public int insertSaleOrders(String sId, String sNumber, String sPay, String client, String sketch,String userName) {

        int partId = Integer.parseInt(sId);
        int number = Integer.parseInt(sNumber);
        Users users = usersService.findUserByName(userName);
        int clientId = Integer.parseInt(client);
        int flag = 0;
        try{
            flag = salesorderMapper
                    .insertSaleOrder(number,partId,sketch,
                            users.getId(),clientId,
                            sPay,new Timestamp(System.currentTimeMillis()));
        }catch (Exception e){
            flag = 0 ;
//            e.printStackTrace();
        }

        return flag;
    }

    private SalesOrderEx setValue(Salesorder salesorder ){
        SalesOrderEx salesOrderEx = new SalesOrderEx();
        int userId = salesorder.getUserid();
        int clientId = salesorder.getClientid();
        int partId = salesorder.getPartid();

        Users users = usersService.findUserByUserId(userId);
        Client client = clientService.findClientById(clientId);
        Parts parts = partsService.findPartsById(partId);

        salesOrderEx.setSalesorder(salesorder);
        salesOrderEx.setUsers(users);
        salesOrderEx.setClient(client);
        salesOrderEx.setParts(parts);
        return salesOrderEx;
    }

    /**
     * 设值
     * @param list
     * @return
     */

    private List<SalesOrderVo> setValue(List<Salesorder> list){

        List<SalesOrderVo> salesOrderVoList = new LinkedList<>();
        for (Salesorder salesorder:list
             ) {
            SalesOrderVo salesOrderVo = new SalesOrderVo();
            int userId = salesorder.getUserid();
            int clientId = salesorder.getClientid();
            Users users = usersService.findUserByUserId(userId);
            Client client = clientService.findClientById(clientId);
            salesOrderVo.setUserName(users.getUsername());
            salesOrderVo.setClientName(client.getClientname());

            salesOrderVo.setId(salesorder.getId());
            salesOrderVo.setPartid(salesorder.getPartid());
            salesOrderVo.setSalenumber(salesorder.getSalenumber());
            salesOrderVo.setPayway(salesorder.getPayway());
            salesOrderVo.setSaletime(salesorder.getSaletime());
            if(salesorder.getDescribe()!=null)
            salesOrderVo.setDescribe(salesorder.getDescribe());

            salesOrderVoList.add(salesOrderVo);
        }
        return salesOrderVoList;

    }


}
