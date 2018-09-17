create or replace view roozaneh.v_rate_per_question as
select COALESCE(SUM(cast (r.answer as integer)),0) sm,r.question_id,COALESCE(count(*),0) cnt,SUM(cast (r.answer as float))/COALESCE(count(*),1) avg,COALESCE(null_answers.cnt,0) null_cnt,q.text,row_number() over () id from roozaneh.results r
	join roozaneh.questions q
		on q.id = r.question_id
	left join (
		select count(*) cnt,rr.question_id from roozaneh.results rr
			join roozaneh.questions qq
				on qq.id = rr.question_id
			where qq.type='AGR'
			and rr.answer is null
				group by rr.question_id
		) null_answers
		on q.id = null_answers.question_id
	where q.type='AGR'
	and r.answer is not null
		group by r.question_id,null_answers.cnt,q.text

-------------------------

create view roozaneh.v_rate_per_part as
select row_number() over () as id,AVG(rate.avg),(COALESCE(SUM(cnt),0)/(COALESCE(SUM(cnt),0)+COALESCE(SUM(null_cnt),0)))*100 ANSWERED_PERCENTAGE,q.survey_part_id,sp.title from roozaneh.v_rate_per_question rate
	left join roozaneh.questions q
		on q.id = rate.question_id
	left join roozaneh.survey_parts sp
		on q.survey_part_id = sp.id
	group by q.survey_part_id,sp.title