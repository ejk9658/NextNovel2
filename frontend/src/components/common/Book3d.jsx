import style from "./Book3d.module.css";

export default function Book3d({ type, img }) {
  return (
    <div
      className={style.wrapper}
      style={
        type === "thumbnail"
          ? { transform: "translate(10%, 10%)" }
          : { transform: "scale(1.5) translate(40%, 35%)" }
      }
    >
      <div className={style.book}>
        <div className={style.page1}>
          <img
            src={process.env.REACT_APP_IMAGE_API + img}
            className={style.cover}
            alt="coverimage"
          />
        </div>
        <div className={style.page2}>222</div>
        <div className={style.page3}>333</div>
        <div className={style.page4}>444</div>
        <div className={style.edge} />
      </div>
    </div>
  );
}
