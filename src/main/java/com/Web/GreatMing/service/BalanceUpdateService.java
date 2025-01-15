package com.Web.GreatMing.service;

import com.Web.GreatMing.dao.BalanceUpdate;
import com.Web.GreatMing.dao.BalanceUpdateMapper;
import com.Web.GreatMing.dao.User;
import com.Web.GreatMing.dao.UsersMapper;
import com.Web.GreatMing.exception.MessageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BalanceUpdateService {

    @Autowired
    private BalanceUpdateMapper balanceUpdateMapper;

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private UserService userServiceimpl;

    // 获取所有余额更新记录
    public List<BalanceUpdate> getAllBalanceUpdates() {
        return balanceUpdateMapper.findAllBalanceUpdates();
    }

    // 根据 ID 获取余额更新记录
    public BalanceUpdate findById(long id) {
        return balanceUpdateMapper.findById(id);
    }
    public List<BalanceUpdate> getListBalanceUpdatesByName(String name){
        return balanceUpdateMapper.findByName(name);
    }

    // 添加余额更新记录并更新余额
    @Transactional
    public String addBalanceUpdate(BalanceUpdate balanceUpdate) {
        User user = usersMapper.findByName(balanceUpdate.getName());
        if (user == null) {
            throw new MessageException("User not found");
        }

        double currentBalance = user.getBalance();
        double opreateBalance = balanceUpdate.getBalance();
        double Updatedbalance;

        if (balanceUpdate.isIsadd()) {
            // 如果是增加余额
            Updatedbalance = Double.sum(currentBalance, opreateBalance);
        } else if (!balanceUpdate.isIsadd()) {
            if (currentBalance < opreateBalance) {
                throw new MessageException("Your balance is not enough.");
            }
            Updatedbalance = BigDecimal.valueOf(currentBalance).subtract(BigDecimal.valueOf(opreateBalance)).doubleValue();
        }else {
            throw new MessageException("can't find Isadd attribute.");
        }
        // 更新用户余额
        user.setBalance(Updatedbalance);
        if (!userServiceimpl.updateBalance(user.getId(), Updatedbalance)) {
            throw new MessageException("updatebalance failed.");
        };
        // 添加余额更新记录
        balanceUpdate.setUpdatedbalance(Updatedbalance);
        balanceUpdateMapper.addBalanceUpdate(balanceUpdate);

        return "update balance success!";

    }

    
}

