//-------------------------请加下面QQ请求远程辅助运行代码  ID:3664--------------------------
//-----------------更多毕设, 联系QQ1305637939-------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加下面QQ请求远程辅助运行代码----------------------------
package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Bonus;

@Repository("bonusDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface BonusDAO {

	/**
	 * BonusDAO 接口 可以按名称直接调用bonus.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包bonus.xml里的insertBonus配置 返回值0(失败),1(成功)
	public int insertBonus(Bonus bonus);

	// 更新数据 调用entity包bonus.xml里的updateBonus配置 返回值0(失败),1(成功)
	public int updateBonus(Bonus bonus);

	// 删除数据 调用entity包bonus.xml里的deleteBonus配置 返回值0(失败),1(成功)
	public int deleteBonus(String bonusid);

	// 查询全部数据 调用entity包bonus.xml里的getAllBonus配置 返回List类型的数据
	public List<Bonus> getAllBonus();

	// 按照Bonus类里面的值精确查询 调用entity包bonus.xml里的getBonusByCond配置 返回List类型的数据
	public List<Bonus> getBonusByCond(Bonus bonus);

	// 按照Bonus类里面的值模糊查询 调用entity包bonus.xml里的getBonusByLike配置 返回List类型的数据
	public List<Bonus> getBonusByLike(Bonus bonus);

	// 按主键查询表返回单一的Bonus实例 调用entity包bonus.xml里的getBonusById配置
	public Bonus getBonusById(String bonusid);

}
//-------------------------请加下面QQ请求远程辅助运行代码  ID:3664--------------------------
//-----------------更多毕设, 联系QQ1305637939-------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加下面QQ请求远程辅助运行代码----------------------------
