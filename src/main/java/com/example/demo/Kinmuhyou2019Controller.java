package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class Kinmuhyou2019Controller {
	
	//フィールドを関連ずけてRepositoryクラスをnewしなくてよくなる
	@Autowired
	Kinmuhyou2019Repository repository;
	
	//ログインページ"/"
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView login(ModelAndView mav) {
		
		mav.setViewName("login");
		return mav;
	}
	//ログインページ"/login"
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView getLogin(ModelAndView mav) {
		
		mav.setViewName("login");
		return mav;
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView postLogin(ModelAndView mav) {
		
		mav.setViewName("login");
		return mav;
	}
	//①各ページへのアクセスを設定する。②入力した内容をテーブルに追加

	@RequestMapping(value="/menu",method=RequestMethod.POST)
	public ModelAndView postMenu(ModelAndView mav) {
		mav.setViewName("menu");
		return mav;
	}
	@RequestMapping(value="/menu",method=RequestMethod.GET)
	public ModelAndView getMenu(ModelAndView mav) {
		mav.setViewName("menu");
		return mav;
	}
	
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public ModelAndView list(ModelAndView mav) {
		mav.setViewName("list");
		return mav;
	}

	@RequestMapping(value="/new",method=RequestMethod.POST)
	public ModelAndView postNew(ModelAndView mav) {
		mav.setViewName("new");
		return mav;
	}
	@RequestMapping(value="/new",method=RequestMethod.GET)
	public ModelAndView getNew(ModelAndView mav) {
		mav.setViewName("new");
		return mav;
	}

	//ログイン後のページ
	@RequestMapping(value="/home",method=RequestMethod.POST)
	//@RequestParamでThymeleafを通してloginのusernameを受け取り、name変数にいれる
	public ModelAndView postHome(@RequestParam("mailaddress")String mAddress,ModelAndView mav) {
		//repository.findOne(id);
		//repository.findById(id)
		
		//次回、画面からゲットしたパスワードをリポジトリのパスワードと比較してOKならログイン
		
		
		//リポジトリクラスに定義したfindbyメソッドで指定カラムの値からレコードを取得
		Kinmuhyou2019Entity record = repository.findByMailaddress(mAddress);
		
		//そのレコードから指定したカラムの値をゲットする
		mav.addObject("username",record.getUsername());
		
		//そのレコードから指定したカラムの値をゲットする
		mav.addObject("mailaddress", record.getMailaddress());

		//データベースの値を取得
		Iterable<Kinmuhyou2019Entity> list = repository.findAll();
		mav.addObject("database",list);
		
		//データベースから取得した一行目のデータ
		mav.addObject("line1",repository.getOne(1));

		//データベースから取得した二行目のデータ
		mav.addObject("line2",repository.getOne(2));
		
		//レコードの数
		mav.addObject("count",repository.count());
		
		//${username}に値が入っているのThymeleaf側で値が表示される
		mav.setViewName("/home");
		
		return mav;
	}
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public ModelAndView getHome(@RequestParam("mailaddress")String mAddress,ModelAndView mav){

		//リポジトリクラスに定義したfindbyメソッドで指定カラムの値からレコードを取得
		Kinmuhyou2019Entity record = repository.findByMailaddress(mAddress);
		
		//そのレコードから指定したカラムの値をゲットする
		mav.addObject("username",record.getUsername());
		
		//そのレコードから指定したカラムの値をゲットする
		mav.addObject("mailaddress", record.getMailaddress());

		//データベースの値を取得
		Iterable<Kinmuhyou2019Entity> list = repository.findAll();
		mav.addObject("database",list);
		
		//データベースから取得した一行目のデータ
		mav.addObject("line1",repository.getOne(1));

		//データベースから取得した二行目のデータ
		mav.addObject("line2",repository.getOne(2));
		
		//レコードの数
		mav.addObject("count",repository.count());
		
		//${username}に値が入っているのThymeleaf側で値が表示される
		mav.setViewName("/home");
		
		return mav;
	}
}