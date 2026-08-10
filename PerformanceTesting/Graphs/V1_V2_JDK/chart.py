import os
import matplotlib.pyplot as plt
from matplotlib.lines import Line2D
import pandas as pd

# ---------------------------------------------------------------------------
# Paths
# ---------------------------------------------------------------------------
script_dir = os.path.dirname(os.path.abspath(__file__))
custom_list_csv = os.path.join(script_dir, "CustomLinkedListJmhBenchmark.csv")
custom_doubly_csv = os.path.join(script_dir, "CustomDoublyLinkedListJmhBenchmark.csv")
jdk_csv = os.path.join(script_dir, "LinkedList_performance.csv")

# ---------------------------------------------------------------------------
# Load CSV results
# ---------------------------------------------------------------------------
custom_list_df = pd.read_csv(custom_list_csv, sep=None, engine='python')
custom_doubly_df = pd.read_csv(custom_doubly_csv, sep=None, engine='python')
jdk_df = pd.read_csv(jdk_csv, sep=None, engine='python')

# Clean column names (remove quotes if present)
for df in [custom_list_df, custom_doubly_df, jdk_df]:
    df.columns = [col.strip().replace('"', '') for col in df.columns]
    if "Size" in df.columns:
        df.sort_values("Size", inplace=True)

# Common columns to plot across all three datasets (excluding Size and Winner)
exclude_cols = {"Size", "Winner"}
valid_cols = [
    col for col in custom_list_df.columns
    if col not in exclude_cols and col in custom_doubly_df.columns and col in jdk_df.columns
]

# ---------------------------------------------------------------------------
# Plotting Configuration & Colors
# ---------------------------------------------------------------------------
color_custom_list = "#ff4d4d"  # Red / Coral
color_custom_doubly = "#4dff88"  # Vibrant Mint Green
color_native = "#4da6ff"  # Blue

for method in valid_cols:
    fig, ax = plt.subplots(figsize=(8, 5.5))

    ax.plot(
        custom_list_df["Size"],
        custom_list_df[method],
        color=color_custom_list,
        marker="o",
        markersize=5,
        linestyle="-",
        linewidth=2,
    )
    ax.plot(
        custom_doubly_df["Size"],
        custom_doubly_df[method],
        color=color_custom_doubly,
        marker="o",
        markersize=5,
        linestyle="-",
        linewidth=2,
    )
    ax.plot(
        jdk_df["Size"],
        jdk_df[method],
        color=color_native,
        marker="o",
        markersize=5,
        linestyle="-",
        linewidth=2,
    )

    ax.set_xlim(left=custom_list_df["Size"].min(), right=custom_list_df["Size"].max())

    title = method

    # Dark-mode friendly styling
    ax.set_title(title, fontsize=14, fontweight="bold", color="white", pad=15)
    ax.set_xlabel("Size", fontsize=11, color="white")
    ax.set_ylabel("Time (ns)", fontsize=11, color="white")
    ax.tick_params(axis="both", colors="white")
    ax.grid(True, linestyle="--", alpha=0.3, color="white")
    for spine in ax.spines.values():
        spine.set_color("white")

    legend_elements = [
        Line2D(
            [0], [0],
            marker="o", color="none",
            label="V1",
            markerfacecolor=color_custom_list,
            markeredgecolor=color_custom_list,
            markersize=8, linestyle="None",
        ),
        Line2D(
            [0], [0],
            marker="o", color="none",
            label="V2",
            markerfacecolor=color_custom_doubly,
            markeredgecolor=color_custom_doubly,
            markersize=8, linestyle="None",
        ),
        Line2D(
            [0], [0],
            marker="o", color="none",
            label="JDK",
            markerfacecolor=color_native,
            markeredgecolor=color_native,
            markersize=8, linestyle="None",
        ),
    ]

    legend = ax.legend(
        handles=legend_elements,
        loc="upper center",
        bbox_to_anchor=(0.5, -0.15),
        fontsize=10,
        frameon=False,
        ncol=3,
    )
    for text in legend.get_texts():
        text.set_color("white")

    fig.patch.set_alpha(0.0)
    ax.patch.set_alpha(0.0)

    plt.tight_layout()

    safe_filename = (
        method.replace("(", "_")
        .replace(")", "_")
        .replace(",", "_")
        .replace(".", "_")
        .replace(" ", "_")
    )
    output_image_path = os.path.join(script_dir, f"plot_{safe_filename}.png")
    plt.savefig(output_image_path, transparent=True, bbox_inches="tight")
    plt.close()

print(f"Successfully generated {len(valid_cols)} triple-comparison performance graphs in {script_dir}")