package com.ModMayhem.ModdersMonsters.Entity;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class DoverDemon extends EntityMob{
	public DoverDemon(World par1World) {
		super(par1World);
		this.setSize(1.0F, 4.0F);
		 this.getNavigator().setBreakDoors(true);
		    this.tasks.addTask(0, new EntityAISwimming(this));
		    this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		    this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0D, true));
		    this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
		    this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
		    this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
		    this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		    this.tasks.addTask(3, new EntityAIFleeSun(this, 1.0D));
		    this.tasks.addTask(8, new EntityAILookIdle(this));
		    this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		    this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		    this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, false));
	
	}
	protected void applyEntityAttributes(){

	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(90.0D);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0D);
	    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.0D);
	}
	 public boolean isAIEnabled()
	    {
	        return true;
	    }
	 protected String getLivingSound()
	    {
	        return "mob.skeleton.say";
	    }
	  protected String getHurtSound()
	    {
	        return "mob.skeleton.hurt";
	    }

	    /**
	     * Returns the sound this mob makes on death.
	     */
	    protected String getDeathSound()
	    {
	        return "mob.skeleton.death";
	    }

	    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
	    {
	        this.playSound("mob.skeleton.step", 0.15F, 1.0F);
	    }
	    protected Item getDropItem()
	    {
	        return Items.iron_axe;
	    }
}
