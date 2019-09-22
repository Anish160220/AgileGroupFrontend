package com.example.agilegroupfrontend;

import com.example.agilegroupfrontend.BLL.AddBidBLL;
import com.example.agilegroupfrontend.BLL.BidFightBLL;
import com.example.agilegroupfrontend.BLL.ClosedBidBLL;
import com.example.agilegroupfrontend.BLL.GetAllOngoingBidsBLL;
import com.example.agilegroupfrontend.BLL.GuitarBLL;
import com.example.agilegroupfrontend.BLL.LoginBLL;
import com.example.agilegroupfrontend.BLL.MikeBLL;
import com.example.agilegroupfrontend.BLL.OtherBLL;
import com.example.agilegroupfrontend.BLL.PedalBLL;
import com.example.agilegroupfrontend.BLL.SignupBLL;
import com.example.agilegroupfrontend.BLL.SoldBidsBLL;
import com.example.agilegroupfrontend.BLL.UpdateClosedBidBLL;
import com.example.agilegroupfrontend.BLL.YourAuctionSoldOutActivityBLL;
import com.example.agilegroupfrontend.BLL.YourAuctionWinBLL;

import org.junit.Test;

import model.Date;

import static junit.framework.TestCase.assertEquals;

public class Testing {
    @Test
    public void testLoginPass(){
        LoginBLL loginBLL = new LoginBLL("anish", "anish");
        boolean result = loginBLL.checkUser();
        assertEquals(true, result);
    }
    @Test
    public void testLoginFail(){
        LoginBLL loginBLL = new LoginBLL("aish", "anish");
        boolean result = loginBLL.checkUser();
        assertEquals(true, result);
    }

    @Test
    public void testSignUpPass()
    {
        SignupBLL signupBLL= new SignupBLL("z","z","z","z");
        boolean result = signupBLL.checkRegister();
        assertEquals(true,result);
    }

    @Test
    public void testSignUpFail()
    {
        SignupBLL signupBLL= new SignupBLL("anish","anish","anish","anish");
        boolean result = signupBLL.checkRegister();
        assertEquals(true,result);
    }

    @Test
    public void testAddBid()
    {
        AddBidBLL addBidBLL= new AddBidBLL(2,"imageFile-1569223354005.jpg","Guitar",23,50,40,"2019-10-29","Guitar",2,"Ongoing");
        boolean result = addBidBLL.checkAddBid();
        assertEquals(true,result);
    }

    @Test
    public void testGetOngoingBid()
    {
        GetAllOngoingBidsBLL getAllOngoingBidsBLL = new GetAllOngoingBidsBLL();
        boolean result = getAllOngoingBidsBLL.getAllOngoing();
        assertEquals(true,result);
    }

    @Test
    public void testBidFight()
    {
        BidFightBLL bidFightBLL = new BidFightBLL(1,1,6);
        boolean result = bidFightBLL.checkBidFight();
        assertEquals(true,result);
    }
    @Test
    public void testGetSoldBid()
    {
        SoldBidsBLL soldBidsBLL = new SoldBidsBLL();
        boolean result = soldBidsBLL.getSoldBids();
        assertEquals(true,result);
    }


    @Test
    public void testUserGetSoldBid()
    {
        YourAuctionSoldOutActivityBLL yourAuctionSoldOutActivityBLL = new YourAuctionSoldOutActivityBLL();
        boolean result = yourAuctionSoldOutActivityBLL.getOwnSoldBids();
        assertEquals(true,result);
    }

    @Test
    public void testWinnerBid()
    {
        YourAuctionWinBLL yourAuctionWinBLL = new YourAuctionWinBLL();
        boolean result = yourAuctionWinBLL.getWinBid();
        assertEquals(true,result);
    }

    @Test
    public void testgetGuitarOngoing()
    {
        GuitarBLL guitarBLL = new GuitarBLL();
        boolean result = guitarBLL.getGuitarBid();
        assertEquals(true,result);
    }
    @Test
    public void testGetpedalOngoing()
    {
        PedalBLL pedalBLL = new PedalBLL();
        boolean result = pedalBLL.getPedalBid();
        assertEquals(true,result);
    }

    @Test
    public void testGetmikeongoing()
    {
        MikeBLL mikeBLL = new MikeBLL();
        boolean result = mikeBLL.getMikeBid();
        assertEquals(true,result);
    }

    @Test
    public void testGetOtherOngoing()
    {
        OtherBLL otherBLL = new OtherBLL();
        boolean result = otherBLL.getOtherBId();
        assertEquals(true,result);
    }

    @Test
    public void testGetClosingBid()
    {
        ClosedBidBLL closedBidBLL = new ClosedBidBLL();
        boolean result = closedBidBLL.getClosedBid();
        assertEquals(true,result);
    }

    @Test
    public void testUpdateClosingBid()
    {
        Date date = new Date("2019-10-3");
        UpdateClosedBidBLL updateClosedBidBLL = new UpdateClosedBidBLL(1,date);
        boolean result = updateClosedBidBLL.checkUpdateClosedBid();
        assertEquals(true,result);
    }





}
