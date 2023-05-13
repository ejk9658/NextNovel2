import { instance, tokeninstance } from "../api/Interceptors";
import axios from "axios";

// intro 가져오기 (nickName ver.)
export async function getintro(id, nickName) {
  if (nickName === null) {
    nickName = ""; // nickName이 null인 경우 빈 문자열로 할당
  }
  console.log(nickName + "들어왔스빈다");
  const res = await instance.get(`novel/${id}`, {
    params: {
      nickName: nickName,
    },
  });
  return res;
}

//comment가져오기
export async function getcomment(id, nickName) {
  console.log(nickName + "코멘트로들어왔스빈다");
  if (nickName === null) {
    nickName = ""; // nickName이 null인 경우 빈 문자열로 할당
  }
  const res = await instance.get(`novel/${id}`, {
    params: {
      nickName: nickName,
    },
  });
  return res;
}

// 댓글 삭제하기
export async function deletecomment(commentid) {
  const res = await tokeninstance.delete(`comment/${commentid}`);
  return res;
}

// 글 삭제하기
export async function deletenovel(id) {
  const res = await tokeninstance.delete(`novel/${id}`);
  return res;
}

// 좋아요 하기
export async function postliked(novelId, nickName) {
  const res = await tokeninstance.post(
    "novel/like",
    {
      novelId: novelId,
      nickName: nickName,
    },
    {
      headers: {
        "Content-Type": "application/json",
      },
    }
  );
  return res;
}

// 좋아요 삭제하기
export async function deleteliked(novelId, nickName) {
  const res = await tokeninstance.delete("novel/like", {
    data: JSON.stringify({
      novelId: novelId,
      nickName: nickName,
    }),
    headers: {
      "Content-Type": "application/json",
    },
  });
  return res;
}